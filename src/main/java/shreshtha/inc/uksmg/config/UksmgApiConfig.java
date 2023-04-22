package shreshtha.inc.uksmg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "uksmg.reports.op1")
@Data
public class UksmgApiConfig {

    @Value("${base-url}")
    private String baseUrl;
    @Value("${base-uri}")
    private String baseUri;
    @Value("${initiate}")
    private String initiate;
    @Value("${add.billing-company-info}")
    private String addBillingCompanyInfo;
    @Value("${add.particulars}")
    private String addParticulars;
    @Value("${update.applicable-gsts}")
    private String updateApplicableGsts;
    @Value("${print.report-data.ready}")
    private String isReportDataReady;
    @Value("${update.report-data}")
    private String updateReportData;
    @Value("${update.report-data.downloads}")
    private String updateReportDataDownloads;
    @Value("${downloads.pdf}")
    private String downloadPdf;
    @Value("${end-of-day-transactions}")
    private String endOfDayTransactions;
    @Value("${report-info}")
    private String reportInfo;
    @Value("${report-infos}")
    private String reportInfos;

}
