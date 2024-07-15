package br.com.rafael.techstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ordereds")
public class Ordered implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "quantity_itens")
    private Integer quantityItens;

    @Column(name = "discount")
    private float discount;

    @Column(name = "total")
    private float total;

    public Ordered() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setQuantityItens(Integer quantityItens) {
        this.quantityItens = quantityItens;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Ordered(Long id, Integer userId, Integer quantityItens, float discount, float total) {
        this.id = id;
        this.userId = userId;
        this.quantityItens = quantityItens;
        this.discount = discount;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getQuantityItens() {
        return quantityItens;
    }

    public float getDiscount() {
        return discount;
    }

    public float getTotal() {
        return total;
    }
}
