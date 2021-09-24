package org.itstep.consumer.models;

import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//implements GrantedAuthority
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Data
//@Entity
public class Role  {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    private String description;

//    @Override public String getAuthority() {
//        return getRole();
//    }
}