package br.com.rafael.techstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import br.com.rafael.techstore.models.OrderedItem;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long> {
    @Query("SELECT o FROM OrderedItem o WHERE o.orderedId =:orderedId")
    List<OrderedItem> findByOrderedId(@Param("orderedId") Long orderedId);
}
