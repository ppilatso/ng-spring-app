package com.userman.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userman.usermanager.entities.User;
import com.userman.usermanager.repositories.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUserById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User updateUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}
