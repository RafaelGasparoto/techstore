package br.com.rafael.techstore.dto;

import java.io.Serializable;

public class OrderedDto implements Serializable {
    private Long id;
    private Integer userId;
    private Integer quantityItens;
    private float discount;
    private float total;

    public OrderedDto(Long id, Integer userId, Integer quantityItens, float discount, float total) {
        this.id = id;
        this.userId = userId;
        this.quantityItens = quantityItens;
        this.discount = discount;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantityItens() {
        return quantityItens;
    }

    public void setQuantityItens(Integer quantityItens) {
        this.quantityItens = quantityItens;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
