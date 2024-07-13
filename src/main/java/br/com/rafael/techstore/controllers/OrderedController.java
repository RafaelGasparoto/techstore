package br.com.rafael.techstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafael.techstore.dto.OrderedDto;
import br.com.rafael.techstore.models.Ordered;
import br.com.rafael.techstore.services.OrderedServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ordered")
public class OrderedController {
    @Autowired
    OrderedServices orderedServices;

    @GetMapping(value = "/{id}")
    ResponseEntity<OrderedDto> findOrderedById(@PathVariable(value = "orderId") Long orderId) {
        Ordered ordered = orderedServices.findOrderedById(orderId);
        OrderedDto orderedDto = buildOrderedDto(ordered);
        return ResponseEntity.ok(orderedDto);
    }

    @PostMapping()
    public ResponseEntity<OrderedDto> createOrdered(@RequestBody() Ordered ordered) {
        OrderedDto orderedDto = buildOrderedDto(orderedServices.createOrdered(ordered));
        return ResponseEntity.ok(orderedDto);
    }

    OrderedDto buildOrderedDto(Ordered ordered) {
        return new OrderedDto(
                ordered.getId(),
                ordered.getUserId(),
                ordered.getQuantityItens(),
                ordered.getDiscount(),
                ordered.getTotal());
    }
}
