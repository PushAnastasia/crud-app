package com.nix.ybrcrudapp;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nix.ybrcrudapp.entities.User;

@Service
public class UserService {
  private static List<User> users;

  public static void initUsers() {
    users = new ArrayList<User>() {{
      add(new User(1, "First", "Hi, I'm the First"));
      add(new User(2, "Second", "Hi, I'm the Second"));
      add(new User(3, "Third", "Hi, I'm the Third"));
    }};
  }

  public User addUser(String userName) {
    int id = users.size() + ThreadLocalRandom.current().nextInt(1, 999 + 1);
    User user = new User(id, userName, format("Hi, I'm the %s", userName));
    users.add(user);
    return user;
  }

  public List<User> getUsersList() {
    return users;
  }

  public User getUserById(String id) {
    return findUserById(id);
  }

  public boolean removeUserById(String id) {
    return users.remove(findUserById(id));
  }

  private User findUserById(String id) {
    return users.stream()
                .filter(user -> Integer.parseInt(id) == user.getId())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid user id %s", id)));
  }

}
