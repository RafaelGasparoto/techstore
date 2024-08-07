package br.com.rafael.techstore.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderedDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer userId;
    private Integer quantityItens;
    private float discount;
    private float total;
}
