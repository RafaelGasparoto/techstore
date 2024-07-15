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

    public List<OrderedItem> findByOrderedId(Long orderedId) {
        return this.orderedItemRepository.findByOrderedId(orderedId);
    }

    public List<OrderedItem> saveListOrderedItems(List<OrderedItem> listOrderedItems) {
        return this.orderedItemRepository.saveAll(listOrderedItems);
    }

    public void deleteListOrderedById(List<Long> listOrderedId) {
        this.orderedItemRepository.deleteAllById(listOrderedId);
    }
}
