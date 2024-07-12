package br.com.rafael.techstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafael.techstore.models.Ordered;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Long> {
}
