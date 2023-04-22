package shreshtha.inc.uksmg.data.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import shreshtha.inc.uksmg.data.enums.IsPaid;
import shreshtha.inc.uksmg.data.enums.TaxPayableUnderReverseCharge;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportData {
    private String accountNo;
    private String bankName;
    private String branchName;
    private String downloadedAt;
    private String ifscCode;
    private String posCity;
    private String posState;
    private TaxPayableUnderReverseCharge taxPayableUnderReverseCharge = TaxPayableUnderReverseCharge.NO;
    private BigDecimal amountChargeable;
    private String amountChargeableInWords;
    private String dateOfSupply = LocalDate.now().toString();
    private BigDecimal totalTaxableValue = BigDecimal.ZERO;
    private IsPaid isPaid = IsPaid.NO;
    private String poNo;
    private Boolean isPrintAllowed = false;
    private String currentDate = LocalDate.now().toString();
    private List<ApplicableGst> applicableGsts = new ArrayList<>();
    private List<CompanyInfo> companyInfos = new ArrayList<>();
    private List<Particular> particulars = new ArrayList<>();

}
