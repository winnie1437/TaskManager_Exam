package org.itstep.consumer.services;

//import org.springframework.security.core.userdetails.UserDetailsService;
// extends UserDetailsService
import org.itstep.consumer.models.User;

import java.util.List;

public interface UserService{

    User getUserByUserName(String userName);

    User getUserById(Long userId);

    User registerUser(User user);

    User updateUser(User user);

    Boolean deleteUser(Long id);

    List<User> getUsers();

}
