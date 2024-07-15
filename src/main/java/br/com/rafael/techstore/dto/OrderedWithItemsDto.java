package br.com.rafael.techstore.dto;

import java.io.Serializable;
import java.util.List;

public class OrderedWithItemsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer userId;
    private Integer quantityItens;
    private float discount;
    private float total;
    private List<OrderedItemDto> listOrderedItemDtos;

    public OrderedWithItemsDto() {
    }

    public OrderedWithItemsDto(Long id, Integer userId, Integer quantityItens, float discount, float total,
            List<OrderedItemDto> listOrderedItemDtos) {
        this.id = id;
        this.userId = userId;
        this.quantityItens = quantityItens;
        this.discount = discount;
        this.total = total;
        this.listOrderedItemDtos = listOrderedItemDtos;
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

    public List<OrderedItemDto> getListOrderedItemDtos() {
        return listOrderedItemDtos;
    }

    public void setListOrderedItemDtos(List<OrderedItemDto> listOrderedItemDtos) {
        this.listOrderedItemDtos = listOrderedItemDtos;
    }

}
