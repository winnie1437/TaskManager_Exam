package org.itstep.producer.controllers;

import org.itstep.producer.exceptions.UserNotFoundException;
import org.itstep.producer.exceptions.UserUnsupportedFieldException;
import org.itstep.producer.models.User;
import org.itstep.producer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.orElseThrow(() -> new UserNotFoundException(id));
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted)
            return new ResponseEntity<>("DELETED", HttpStatus.OK);
        else
            return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.getUserById(id).map(u -> {
            u.setUserName(updatedUser.getUserName());
            u.setPassword(updatedUser.getPassword());
            return userService.updateUser(u);
        }).orElseGet(() -> {
            updatedUser.setUserId(id);
            return userService.registerUser(updatedUser);
        });
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    @PatchMapping("/{id}")
    public User patchUser(@PathVariable Long id, @RequestBody Map<String, String> passMap) {
        return userService.getUserById(id).map(u -> {
            String pass = passMap.get("password");
            if (Objects.nonNull(pass)) {
                u.setPassword(pass);
                return userService.updateUser(u);
            } else {
                throw new UserUnsupportedFieldException(id);
            }
        }).orElseGet(() -> {
            throw new UserNotFoundException(id);
        });
    }
}
