package org.itstep.consumer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.List;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
    private Long userId;

//    @Column(name="user_name")
    private String userName;

    private String password;

//    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}