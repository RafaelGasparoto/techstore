package br.com.rafael.techstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.techstore.models.OrderedItem;
import br.com.rafael.techstore.repositories.OrderedItemRepository;

@Service
public class OrderedItemServices {

    @Autowired
    OrderedItemRepository orderedItemRepository;

    List<OrderedItem> findByOrderedId(Long orderedId) {
        return this.orderedItemRepository.findByOrderedId(orderedId);
    }
}
