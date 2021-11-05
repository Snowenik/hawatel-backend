package com.hawatel.monolithic.product;

import java.math.BigDecimal;

public class NewProductDTO {

    private Long userId;

    private String product;

    private BigDecimal value;

    private Integer amount;

    private String comment;

    public Long getUserId() {
        return userId;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }
}
