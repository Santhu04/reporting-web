package shreshtha.inc.uksmg.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Particular {
    private BigDecimal amountInfo;
    private String descriptionOfGoodsOrService;
    private String hsnSacCode;
    private Integer quantityOrSize;
    private BigDecimal unitAmountInfo;
    private String unitAmountSummary;
    private Integer units;
    private BigDecimal gstAmount;

}
