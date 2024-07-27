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

import com.userman.usermanager.entities.Role;
import com.userman.usermanager.services.RoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roles")
public class RoleController {

  @Autowired
  RoleService roleService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Role> createRole(@RequestBody Role role) {
    Role newRole = roleService.createRole(role);
    return new ResponseEntity<Role>(newRole, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Role> getRoleById(@PathVariable String roleId) {
    Role roleFound = roleService.getRoleById(roleId);
    return new ResponseEntity<Role>(roleFound, HttpStatus.OK);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Role>> getAllRoles() {
    List<Role> roles = roleService.getAllRoles();
    return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Role> updateRole(@RequestBody Role role) {
    Role updatedRole = roleService.updateRole(role);
    return new ResponseEntity<Role>(updatedRole, HttpStatus.ACCEPTED);
  }

  @DeleteMapping(path = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteRole(@PathVariable String roleId) {
    roleService.deleteRole(roleId);
    return new ResponseEntity<String>("Role deleted", HttpStatus.NO_CONTENT);
  }
}
