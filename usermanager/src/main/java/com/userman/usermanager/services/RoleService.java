package com.userman.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userman.usermanager.entities.Role;
import com.userman.usermanager.repositories.RoleRepositories;

@Service
public class RoleService {

  @Autowired
  RoleRepositories roleRepositories;

  public Role createRole(Role role) {
    return roleRepositories.save(role);
  }

  public Role getRoleById(String id) {
    return roleRepositories.findById(id).orElse(null);
  }

  public List<Role> getAllRoles() {
    return roleRepositories.findAll();
  }

  public Role updateRole(Role role) {
    return roleRepositories.save(role);
  }

  public void deleteRole(String id) {
    roleRepositories.deleteById(id);
  }
}
