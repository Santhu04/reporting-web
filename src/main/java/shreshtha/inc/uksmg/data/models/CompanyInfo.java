package shreshtha.inc.uksmg.data.models;

import lombok.Data;
import shreshtha.inc.uksmg.data.enums.CompanyCategory;

@Data
public class CompanyInfo {

    private String addressLine;

    private CompanyCategory category;

    private String companyName;

    private String emailAddress;

    private String gstNo;

    private String panNo;

    private String phoneNumber;

    private String pinCode;

}
