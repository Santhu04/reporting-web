package shreshtha.inc.uksmg.data.enums;

public enum JasperReportTitle {
    TAX_INVOICE("Tax Invoice");

    private final String title;

    JasperReportTitle(String title) {
        this.title = title;
    }

    public String findByEnumType() {
        return this.title;
    }
}
