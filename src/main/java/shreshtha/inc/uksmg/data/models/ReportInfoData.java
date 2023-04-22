package shreshtha.inc.uksmg.data.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportInfoData implements Serializable {
    private String invoiceNo;
    private ReportData reportData;
}
