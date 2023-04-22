package shreshtha.inc.uksmg.data.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import shreshtha.inc.uksmg.data.enums.GstCategory;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class ApplicableGst {
    private BigDecimal amountInfo;
    private GstCategory category;
    private Double percentageApplicable;
}
