package br.com.rafael.techstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafael.techstore.models.User;
import br.com.rafael.techstore.repositories.UserRepository;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.save(user);
    }
}
