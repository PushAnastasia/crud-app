package com.nix.ybrcrudapp.controller;

import com.nix.ybrcrudapp.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@RestController
@RequestMapping("user")
public class UsersController {
    private static List<User> users;

    public static void initUsers() {
        users = new ArrayList<User>() {{
            add(new User(1, "First", "Hi, I'm the First"));
            add(new User(2, "Second", "Hi, I'm the Second"));
            add(new User(3, "Third", "Hi, I'm the Third"));
        }};
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable String id) {
        return users.stream().filter(item -> item.getId() == Integer.parseInt(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(format("The user is not found for ID: %s", id)));
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable String id) {
        users.remove(getUser(id));
       return "";
    }
}
