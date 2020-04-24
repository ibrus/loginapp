package com.example.loginapp.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message="field should not be empty")
//    @Size(min=1, max=32, message="Name must be between 6 and 32 characters")
    private String username;

//    @NotNull(message="field should not be empty")
//    @Size(min=6, max=32, message="Password must be between 6 and 32 characters")
    private String password;

    @Transient
    private String passwordConfirm;
}