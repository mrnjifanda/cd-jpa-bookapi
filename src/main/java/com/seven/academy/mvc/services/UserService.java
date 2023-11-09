package com.seven.academy.mvc.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.seven.academy.mvc.models.User;
import com.seven.academy.mvc.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService (UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> find() {

        return this.userRepository.findAll();
    }

    public User create(User newUser) {

        return this.userRepository.save(newUser);
    }
}
