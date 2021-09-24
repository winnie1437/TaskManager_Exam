package org.itstep.producer.services;

import org.itstep.producer.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserByUserName(String userName);

    Optional<User> getUserById(Long userId);

    User registerUser(User user);

    User updateUser(User user);

    Boolean deleteUser(Long id);

    List<User> getUsers();

}