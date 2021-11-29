package com.nix.ybrcrudapp.entities;

import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String message;

    public User(long id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
}
