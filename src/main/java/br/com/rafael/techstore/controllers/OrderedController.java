package br.com.rafael.techstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rafael.techstore.dto.OrderedDto;
import br.com.rafael.techstore.dto.OrderedItemDto;
import br.com.rafael.techstore.dto.OrderedWithItemsDto;
import br.com.rafael.techstore.models.Ordered;
import br.com.rafael.techstore.models.OrderedItem;
import br.com.rafael.techstore.services.OrderedItemServices;
import br.com.rafael.techstore.services.OrderedServices;
import br.com.rafael.techstore.mapper.DozerMapper;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/ordered")
public class OrderedController {
    @Autowired
    OrderedServices orderedServices;

    @Autowired
    OrderedItemServices orderedItemServices;

    @GetMapping(value = "/{id}")
    ResponseEntity<OrderedDto> findOrderedById(@PathVariable(value = "id") Long orderId) {
        Ordered ordered = orderedServices.findOrderedById(orderId);
        OrderedDto orderedDto = buildOrderedDto(ordered);
        return ResponseEntity.ok(orderedDto);
    }

    @PostMapping()
    public ResponseEntity<OrderedWithItemsDto> createOrdered(@RequestBody() OrderedWithItemsDto orderedWithItemsDto) {
        Ordered ordered = buildOrdered(orderedWithItemsDto);
        List<OrderedItem> listOrderedItems = new ArrayList<OrderedItem>();

        try {
            orderedWithItemsDto.setId(orderedServices.createOrdered(ordered).getId());

            for (OrderedItemDto orderedItemDto : orderedWithItemsDto.getListOrderedItemDtos()) {
                orderedItemDto.setOrderedId(ordered.getId());
                listOrderedItems.add(buildOrderedItem(orderedItemDto));
            }
            orderedWithItemsDto.setListOrderedItemDtos(buildListOrderedItemDto(orderedItemServices.saveListOrderedItems(listOrderedItems)));
        } catch (Exception e) {
            List<Long> listOrderedId = new ArrayList<Long>();
            listOrderedItems.forEach((orderedItem) -> listOrderedId.add(orderedItem.getId()));
            orderedItemServices.deleteListOrderedById(listOrderedId);
            orderedServices.deleteOrderedById(orderedWithItemsDto.getId());
            orderedWithItemsDto = null;
        }

        return ResponseEntity.ok(orderedWithItemsDto);
    }

    Ordered buildOrdered(OrderedWithItemsDto orderedWithItemsDto) {
        return DozerMapper.parseObject(orderedWithItemsDto, Ordered.class);
    }

    OrderedItem buildOrderedItem(OrderedItemDto orderedItemDto) {
        return DozerMapper.parseObject(orderedItemDto, OrderedItem.class);
    }

    OrderedDto buildOrderedDto(Ordered ordered) {
        return DozerMapper.parseObject(ordered, OrderedDto.class);
    }

    OrderedWithItemsDto buildOrderedWithItemsDto(Ordered ordered) {
        return DozerMapper.parseObject(ordered, OrderedWithItemsDto.class);
    }
    List<OrderedItemDto> buildListOrderedItemDto(List<OrderedItem> listItems) {
        return DozerMapper.parseListObject(listItems, OrderedItemDto.class);
    }
}
