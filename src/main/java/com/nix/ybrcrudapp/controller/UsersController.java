package com.nix.ybrcrudapp.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nix.ybrcrudapp.UserService;
import com.nix.ybrcrudapp.entities.User;
import com.nix.ybrcrudapp.entities.UserDTO;

@RestController
@RequestMapping("user")
public class UsersController {

  @Autowired
  private UserService userService;

  @GetMapping()
  public List<User> getUsers() {
    return userService.getUsersList();
  }

  @GetMapping("{id}")
  public User getUser(@PathVariable String id) {
    return userService.getUserById(id);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<List<User>> deleteUser(@PathVariable String id) {
    userService.removeUserById(id);
    return new ResponseEntity<>(userService.getUsersList(), HttpStatus.OK);
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
               produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public ResponseEntity<User> postUser(@RequestBody UserDTO userToBeCreated) throws Exception {
    User user = userService.addUser(userToBeCreated.getName());
    if (user == null) {
      throw new ServerException("User is null");
    } else {
      return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
  }
}
