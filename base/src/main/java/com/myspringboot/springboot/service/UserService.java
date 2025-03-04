package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private final Map<Long, User> userDB = new HashMap<>();
    private long idCounter = 1;

    // Create
    public User createUser(User user) {
        user.setId(idCounter++);
        userDB.put(user.getId(), user);
        return user;
    }

    // Read All
    public List<User> getAllUsers() {
        return new ArrayList<>(userDB.values());
    }

    // Read One
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userDB.get(id));
    }

    // Update (ID is now in JSON body)
    public Optional<User> updateUser(Long id, User newUser) {
        if (userDB.containsKey(id)) {
            newUser.setId(id);
            userDB.put(id, newUser);
            return Optional.of(newUser);
        }
        return Optional.empty();
    }

    // Delete (ID is now in JSON body)
    public boolean deleteUser(Long id) {
        return userDB.remove(id) != null;
    }
}
