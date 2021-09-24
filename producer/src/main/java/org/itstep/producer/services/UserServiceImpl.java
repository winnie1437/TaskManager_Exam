package org.itstep.producer.services;

import org.itstep.producer.models.User;
import org.itstep.producer.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public User registerUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }
}
