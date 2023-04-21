package shreshtha.inc.uksmg.views.transactions;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import jakarta.annotation.security.RolesAllowed;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import shreshtha.inc.uksmg.data.entity.ReportInfo;
import shreshtha.inc.uksmg.data.service.ReportInfoService;
import shreshtha.inc.uksmg.views.MainLayout;

@PageTitle("Transactions")
@Route(value = "transactions/:reportInfoID?/:action?(edit)", layout = MainLayout.class)
@RolesAllowed("USER")
@Uses(Icon.class)
public class TransactionsView extends Div implements BeforeEnterObserver {

    private final String REPORTINFO_ID = "reportInfoID";
    private final String REPORTINFO_EDIT_ROUTE_TEMPLATE = "transactions/%s/edit";

    private final Grid<ReportInfo> grid = new Grid<>(ReportInfo.class, false);

    private TextField invoiceNo;
    private TextField accountNo;
    private TextField bankName;
    private TextField branchName;
    private TextField downloadedAt;
    private TextField ifscCode;
    private TextField posCity;
    private TextField posState;
    private TextField taxPayableUnderReverseCharge;
    private TextField amountChargeable;
    private TextField amountChargeableInWords;
    private TextField dateOfSupply;
    private TextField totalTaxableValue;
    private TextField isPaid;
    private TextField poNo;
    private Checkbox isPrintAllowed;
    private TextField currentDate;
    private TextField addressLine;
    private TextField companyName;
    private TextField emailAddress;
    private TextField gstNo;
    private TextField panNo;
    private TextField phoneNumber;
    private TextField pinCode;
    private TextField billingAddressLine;
    private TextField billingCompanyName;
    private TextField billingEmailAddress;
    private TextField billingGstNo;
    private TextField billingPanNo;
    private TextField billingPhoneNumber;
    private TextField billingPinCode;

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");

    private final BeanValidationBinder<ReportInfo> binder;

    private ReportInfo reportInfo;

    private final ReportInfoService reportInfoService;

    public TransactionsView(ReportInfoService reportInfoService) {
        this.reportInfoService = reportInfoService;
        addClassNames("transactions-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("invoiceNo").setAutoWidth(true);
        grid.addColumn("accountNo").setAutoWidth(true);
        grid.addColumn("bankName").setAutoWidth(true);
        grid.addColumn("branchName").setAutoWidth(true);
        grid.addColumn("downloadedAt").setAutoWidth(true);
        grid.addColumn("ifscCode").setAutoWidth(true);
        grid.addColumn("posCity").setAutoWidth(true);
        grid.addColumn("posState").setAutoWidth(true);
        grid.addColumn("taxPayableUnderReverseCharge").setAutoWidth(true);
        grid.addColumn("amountChargeable").setAutoWidth(true);
        grid.addColumn("amountChargeableInWords").setAutoWidth(true);
        grid.addColumn("dateOfSupply").setAutoWidth(true);
        grid.addColumn("totalTaxableValue").setAutoWidth(true);
        grid.addColumn("isPaid").setAutoWidth(true);
        grid.addColumn("poNo").setAutoWidth(true);
        LitRenderer<ReportInfo> isPrintAllowedRenderer = LitRenderer.<ReportInfo>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", isPrintAllowed -> isPrintAllowed.isIsPrintAllowed() ? "check" : "minus")
                .withProperty("color",
                        isPrintAllowed -> isPrintAllowed.isIsPrintAllowed()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(isPrintAllowedRenderer).setHeader("Is Print Allowed").setAutoWidth(true);

        grid.addColumn("currentDate").setAutoWidth(true);
        grid.addColumn("addressLine").setAutoWidth(true);
        grid.addColumn("companyName").setAutoWidth(true);
        grid.addColumn("emailAddress").setAutoWidth(true);
        grid.addColumn("gstNo").setAutoWidth(true);
        grid.addColumn("panNo").setAutoWidth(true);
        grid.addColumn("phoneNumber").setAutoWidth(true);
        grid.addColumn("pinCode").setAutoWidth(true);
        grid.addColumn("billingAddressLine").setAutoWidth(true);
        grid.addColumn("billingCompanyName").setAutoWidth(true);
        grid.addColumn("billingEmailAddress").setAutoWidth(true);
        grid.addColumn("billingGstNo").setAutoWidth(true);
        grid.addColumn("billingPanNo").setAutoWidth(true);
        grid.addColumn("billingPhoneNumber").setAutoWidth(true);
        grid.addColumn("billingPinCode").setAutoWidth(true);
        grid.setItems(query -> reportInfoService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(REPORTINFO_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(TransactionsView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(ReportInfo.class);

        // Bind fields. This is where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.reportInfo == null) {
                    this.reportInfo = new ReportInfo();
                }
                binder.writeBean(this.reportInfo);
                reportInfoService.update(this.reportInfo);
                clearForm();
                refreshGrid();
                Notification.show("Data updated");
                UI.getCurrent().navigate(TransactionsView.class);
            } catch (ObjectOptimisticLockingFailureException exception) {
                Notification n = Notification.show(
                        "Error updating the data. Somebody else has updated the record while you were making changes.");
                n.setPosition(Position.MIDDLE);
                n.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } catch (ValidationException validationException) {
                Notification.show("Failed to update the data. Check again that all values are valid");
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Long> reportInfoId = event.getRouteParameters().get(REPORTINFO_ID).map(Long::parseLong);
        if (reportInfoId.isPresent()) {
            Optional<ReportInfo> reportInfoFromBackend = reportInfoService.get(reportInfoId.get());
            if (reportInfoFromBackend.isPresent()) {
                populateForm(reportInfoFromBackend.get());
            } else {
                Notification.show(String.format("The requested reportInfo was not found, ID = %s", reportInfoId.get()),
                        3000, Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(TransactionsView.class);
            }
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setClassName("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        invoiceNo = new TextField("Invoice No");
        accountNo = new TextField("Account No");
        bankName = new TextField("Bank Name");
        branchName = new TextField("Branch Name");
        downloadedAt = new TextField("Downloaded At");
        ifscCode = new TextField("Ifsc Code");
        posCity = new TextField("Pos City");
        posState = new TextField("Pos State");
        taxPayableUnderReverseCharge = new TextField("Tax Payable Under Reverse Charge");
        amountChargeable = new TextField("Amount Chargeable");
        amountChargeableInWords = new TextField("Amount Chargeable In Words");
        dateOfSupply = new TextField("Date Of Supply");
        totalTaxableValue = new TextField("Total Taxable Value");
        isPaid = new TextField("Is Paid");
        poNo = new TextField("Po No");
        isPrintAllowed = new Checkbox("Is Print Allowed");
        currentDate = new TextField("Current Date");
        addressLine = new TextField("Address Line");
        companyName = new TextField("Company Name");
        emailAddress = new TextField("Email Address");
        gstNo = new TextField("Gst No");
        panNo = new TextField("Pan No");
        phoneNumber = new TextField("Phone Number");
        pinCode = new TextField("Pin Code");
        billingAddressLine = new TextField("Billing Address Line");
        billingCompanyName = new TextField("Billing Company Name");
        billingEmailAddress = new TextField("Billing Email Address");
        billingGstNo = new TextField("Billing Gst No");
        billingPanNo = new TextField("Billing Pan No");
        billingPhoneNumber = new TextField("Billing Phone Number");
        billingPinCode = new TextField("Billing Pin Code");
        formLayout.add(invoiceNo, accountNo, bankName, branchName, downloadedAt, ifscCode, posCity, posState,
                taxPayableUnderReverseCharge, amountChargeable, amountChargeableInWords, dateOfSupply,
                totalTaxableValue, isPaid, poNo, isPrintAllowed, currentDate, addressLine, companyName, emailAddress,
                gstNo, panNo, phoneNumber, pinCode, billingAddressLine, billingCompanyName, billingEmailAddress,
                billingGstNo, billingPanNo, billingPhoneNumber, billingPinCode);

        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("button-layout");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setClassName("grid-wrapper");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(ReportInfo value) {
        this.reportInfo = value;
        binder.readBean(this.reportInfo);

    }
}
