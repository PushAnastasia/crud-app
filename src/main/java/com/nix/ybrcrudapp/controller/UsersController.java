package com.nix.ybrcrudapp.controller;

import com.nix.ybrcrudapp.entities.User;
import com.nix.ybrcrudapp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@RestController
@RequestMapping("user")
public class UsersController {
    private static List<User> users;
    private int counter = 4;

    public static void initUsers() {
        users = new ArrayList<User>() {{
            add(new User(1, "First", "Hi, I'm the First"));
            add(new User(2, "Second", "Hi, I'm the Second"));
            add(new User(3, "Third", "Hi, I'm the Third"));
        }};
    }

    @GetMapping
    private List<User> getUsers() {
        return users;
    }

    @GetMapping("{id}")
    private User getUser(@PathVariable String id) {
        return getUserFromDb(id);
    }

    @DeleteMapping("{id}")
    private List<User> deleteUser(@PathVariable String id) {
        users.remove(getUserFromDb(id));
        counter--;
        return users;
    }

    @PostMapping()
    private List<User> createUser(@RequestBody Map<String, String> user) {
        String key = (String) user.keySet().toArray()[0];
        users.add(new User(counter++, key, user.get(key)));
        return users;
    }

    @PutMapping("{id}")
    private User createUser(@PathVariable String id, @RequestBody Map<String, String> user) {
        User userFromDb = getUserFromDb(id);
        String key = (String) user.keySet().toArray()[0];
        userFromDb.setName(key);
        userFromDb.setMessage(user.get(key));
        return userFromDb;
    }

    private User getUserFromDb(String id) {
        return users.stream().filter(item -> item.getId() == Integer.parseInt(id))
                .findFirst().orElseThrow(() -> new NotFoundException(format("The user is not found for ID: %s", id)));
    }
}
