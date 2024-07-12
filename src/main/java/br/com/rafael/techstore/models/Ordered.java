package br.com.rafael.techstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordereds")
public class Ordered {
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
}
