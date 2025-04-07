package com.kornel.progtech.repository;

import com.kornel.progtech.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public boolean delete(Long id) {
        return users.removeIf(u -> u.getId().equals(id));
    }

    public Optional<User> update(Long id, User newUser) {
        return findById(id).map(existingUser -> {
            existingUser.setName(newUser.getName());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setAge(newUser.getAge());
            return existingUser;
        });
    }
}
