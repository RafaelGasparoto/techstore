package br.com.rafael.techstore.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderedWithItemsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotNull(message = "userId é obrigatório")
    private Integer userId;
    private Integer quantityItens;
    private float discount;
    private float total;
    @NotEmpty(message = "listOrderedItemDtos pedido precisa de pelo menos 1 item")
    private List<OrderedItemDto> listOrderedItemDtos;
}
