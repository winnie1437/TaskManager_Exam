package org.itstep.consumer.services;

import org.itstep.consumer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@EnableWebSecurity
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    @Value("$rest.user.BASE_URL")
    String url;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public User getUserByUserName(String userName) {

        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("admin", "12345"));
        ResponseEntity responseEntity =
                restTemplate.getForEntity(url, User[].class);
        User[] userArray = (User[]) responseEntity.getBody();

        List<User> users = Arrays.asList(userArray);

        for(User u : users){
            if(u.getUserName().equals(userName))
                return u;
        }

        return null;
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User foundedUser = restTemplate.getForObject(url+userName, User.class);
//        UserDetails user = org.springframework.security.core.userdetails.User
//                .builder()
//                .username(foundedUser.getUserName())
//                .password(foundedUser.getPassword())
//                .roles(foundedUser.getRoles().toArray(String[]::new))
//                .build();
//        return user;
//    }
}
