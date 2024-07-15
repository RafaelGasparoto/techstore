package br.com.rafael.techstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.com.rafael.techstore.models.Ordered;
import br.com.rafael.techstore.repositories.OrderedRepository;

@Service
public class OrderedServices {
    @Autowired
    OrderedRepository orderedRepository;

    public Ordered findOrderedById(Long orderedId) {
        return this.orderedRepository.findById(orderedId)
                .orElseThrow(() -> new ResourceAccessException("Pedido não encontrado"));
    }

    public Ordered createOrdered(Ordered ordered) {
        return this.orderedRepository.save(ordered);
    }

    public void deleteOrderedById(Long orderedId) {
        this.orderedRepository.deleteById(orderedId);
    }

}
