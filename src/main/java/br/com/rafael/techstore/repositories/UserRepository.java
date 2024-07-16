package br.com.rafael.techstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafael.techstore.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
