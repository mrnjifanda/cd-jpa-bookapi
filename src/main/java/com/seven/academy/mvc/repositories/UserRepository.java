package com.seven.academy.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.seven.academy.mvc.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findAll();
}
