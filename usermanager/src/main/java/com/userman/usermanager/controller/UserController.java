package com.userman.usermanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userman.usermanager.entities.User;
import com.userman.usermanager.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userService.createUser(user);

    return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUserById(@PathVariable String userId) {
    User userFound = userService.getUserById(userId);
    return new ResponseEntity<User>(userFound, HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    User updatedUser = userService.updateUser(user);
    return new ResponseEntity<User>(updatedUser, HttpStatus.ACCEPTED);
  }

  @DeleteMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteUser(@PathVariable String userId) {
    userService.deleteUser(userId);
    return new ResponseEntity<String>("User deleted", HttpStatus.NO_CONTENT);
  }
}
