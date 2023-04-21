package shreshtha.inc.uksmg.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;

@Entity
public class ReportInfo extends AbstractEntity {

    private String invoiceNo;
    private String accountNo;
    private String bankName;
    private String branchName;
    private String downloadedAt;
    private String ifscCode;
    private String posCity;
    private String posState;
    private String taxPayableUnderReverseCharge;
    private String amountChargeable;
    private String amountChargeableInWords;
    private String dateOfSupply;
    private String totalTaxableValue;
    private String isPaid;
    private String poNo;
    private boolean isPrintAllowed;
    private String currentDate;
    private String addressLine;
    private String companyName;
    @Email
    private String emailAddress;
    private String gstNo;
    private String panNo;
    private String phoneNumber;
    private String pinCode;
    private String billingAddressLine;
    private String billingCompanyName;
    @Email
    private String billingEmailAddress;
    private String billingGstNo;
    private String billingPanNo;
    private String billingPhoneNumber;
    private String billingPinCode;

    public String getInvoiceNo() {
        return invoiceNo;
    }
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getDownloadedAt() {
        return downloadedAt;
    }
    public void setDownloadedAt(String downloadedAt) {
        this.downloadedAt = downloadedAt;
    }
    public String getIfscCode() {
        return ifscCode;
    }
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    public String getPosCity() {
        return posCity;
    }
    public void setPosCity(String posCity) {
        this.posCity = posCity;
    }
    public String getPosState() {
        return posState;
    }
    public void setPosState(String posState) {
        this.posState = posState;
    }
    public String getTaxPayableUnderReverseCharge() {
        return taxPayableUnderReverseCharge;
    }
    public void setTaxPayableUnderReverseCharge(String taxPayableUnderReverseCharge) {
        this.taxPayableUnderReverseCharge = taxPayableUnderReverseCharge;
    }
    public String getAmountChargeable() {
        return amountChargeable;
    }
    public void setAmountChargeable(String amountChargeable) {
        this.amountChargeable = amountChargeable;
    }
    public String getAmountChargeableInWords() {
        return amountChargeableInWords;
    }
    public void setAmountChargeableInWords(String amountChargeableInWords) {
        this.amountChargeableInWords = amountChargeableInWords;
    }
    public String getDateOfSupply() {
        return dateOfSupply;
    }
    public void setDateOfSupply(String dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }
    public String getTotalTaxableValue() {
        return totalTaxableValue;
    }
    public void setTotalTaxableValue(String totalTaxableValue) {
        this.totalTaxableValue = totalTaxableValue;
    }
    public String getIsPaid() {
        return isPaid;
    }
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
    public String getPoNo() {
        return poNo;
    }
    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }
    public boolean isIsPrintAllowed() {
        return isPrintAllowed;
    }
    public void setIsPrintAllowed(boolean isPrintAllowed) {
        this.isPrintAllowed = isPrintAllowed;
    }
    public String getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    public String getAddressLine() {
        return addressLine;
    }
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getGstNo() {
        return gstNo;
    }
    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }
    public String getPanNo() {
        return panNo;
    }
    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPinCode() {
        return pinCode;
    }
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    public String getBillingAddressLine() {
        return billingAddressLine;
    }
    public void setBillingAddressLine(String billingAddressLine) {
        this.billingAddressLine = billingAddressLine;
    }
    public String getBillingCompanyName() {
        return billingCompanyName;
    }
    public void setBillingCompanyName(String billingCompanyName) {
        this.billingCompanyName = billingCompanyName;
    }
    public String getBillingEmailAddress() {
        return billingEmailAddress;
    }
    public void setBillingEmailAddress(String billingEmailAddress) {
        this.billingEmailAddress = billingEmailAddress;
    }
    public String getBillingGstNo() {
        return billingGstNo;
    }
    public void setBillingGstNo(String billingGstNo) {
        this.billingGstNo = billingGstNo;
    }
    public String getBillingPanNo() {
        return billingPanNo;
    }
    public void setBillingPanNo(String billingPanNo) {
        this.billingPanNo = billingPanNo;
    }
    public String getBillingPhoneNumber() {
        return billingPhoneNumber;
    }
    public void setBillingPhoneNumber(String billingPhoneNumber) {
        this.billingPhoneNumber = billingPhoneNumber;
    }
    public String getBillingPinCode() {
        return billingPinCode;
    }
    public void setBillingPinCode(String billingPinCode) {
        this.billingPinCode = billingPinCode;
    }

}
