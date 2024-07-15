package br.com.rafael.techstore.dto;

import java.io.Serializable;

public class OrderedItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderedId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Float price;
    private Float discount;

    public OrderedItemDto() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderedId() {
        return orderedId;
    }
    public void setOrderedId(Long orderedId) {
        this.orderedId = orderedId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getDiscount() {
        return discount;
    }
    public void setDiscount(Float discount) {
        this.discount = discount;
    } 

    
}
