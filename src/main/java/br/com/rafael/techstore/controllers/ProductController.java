package br.com.rafael.techstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import br.com.rafael.techstore.dto.PageResponseDto;
import br.com.rafael.techstore.models.Product;
import br.com.rafael.techstore.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping()
    public ResponseEntity<PageResponseDto> findProducts(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "offset", defaultValue = "2") Integer offSet,
            @RequestParam(value = "order", defaultValue = "ASC") String order) {

        Direction orderDirection = order.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC;
        Pageable pageable = PageRequest.of(page, offSet, Sort.by(orderDirection, "name"));

        PageResponseDto pageResponseDto = null;
        var response = productServices.findAll(pageable);

        if (response != null)
            pageResponseDto = this.buildPageResponse(response);

        return ResponseEntity.ok(pageResponseDto);
    }

    PageResponseDto buildPageResponse(Page<Product> response) {
        List<Product> content = response.getContent();
        Integer totalPage = response.getTotalPages();
        boolean isFirst = response.isFirst();
        boolean isLast = response.isLast();

        return new PageResponseDto(content, totalPage, isFirst, isLast);
    }
}
