package com.hawatel.monolithic.product;


import com.hawatel.monolithic.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;


    private String product;

    private BigDecimal value;

    private Integer amount;

    private String comment;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, value, amount, comment, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product productNew = (Product) o;
        return Objects.equals(id, productNew.id) &&
                Objects.equals(product, productNew.product) &&
                Objects.equals(value, productNew.value) &&
                Objects.equals(amount, productNew.amount) &&
                Objects.equals(comment, productNew.comment) &&
                Objects.equals(user, productNew.user);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", value='" + value + '\'' +
                ", amount='" + amount + '\'' +
                ", comment='" + comment + '\'' +
                ", user='" + user + '\'' +
                '}';
    }

}


















