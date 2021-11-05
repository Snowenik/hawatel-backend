package com.hawatel.monolithic.product;

import java.math.BigDecimal;

public class EditProductDTO {

    private Long userId;

    private Long productId;

    private String product;

    private BigDecimal value;

    private Integer amount;

    private String comment;

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
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
