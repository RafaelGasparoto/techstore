package br.com.rafael.techstore.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderedItemDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderedId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Float price;
    private Float discount;
}
