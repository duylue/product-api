package com.productApi.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int uid;
    private String name;
    private String username;
    private String password;
    private String role;

}
