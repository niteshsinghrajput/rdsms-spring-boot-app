package com.rdsms.controller;

/**
 * @author Nitesh
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdsms.entity.Role;
import com.rdsms.entity.User;
import com.rdsms.service.IRdsmsService;

@Controller
@RequestMapping("rdsmsservice")
public class RdsmsController {
	
	@Autowired
	private IRdsmsService service;
	
	@GetMapping("test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("Rdsms Service is up and running successful..", HttpStatus.OK);
	}
	
	@GetMapping("roles")
	public ResponseEntity<List<Role>> getRoles(){
		
		List<Role> roles = service.getRoles();
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@PostMapping("roles")
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		Role r = service.createRole(role);
		return new ResponseEntity<Role>(r,HttpStatus.OK);
	}
	
	@PutMapping("roles/{roleId}")
	public ResponseEntity<Role> updateRole(@PathVariable("roleId") int roleId,@RequestBody Role role){
		Role updatedRole = service.updateRole(roleId, role);
		return new ResponseEntity<Role>(updatedRole,HttpStatus.OK);
	}
	
	@DeleteMapping("roles/{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable("roleId") int roleId) {
		boolean isDeleted = service.deleteRole(roleId);
		String message;
		if(isDeleted) {
			message = "Role (id="+roleId+") has been deleted Successfully";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			message = "Error while deleting Role(id="+roleId+") from database";
			return new ResponseEntity<String>(message,HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("roles/{roleId}")
	public ResponseEntity<Role> getRoleByRoleId(@PathVariable("roleId") int roleId){
		Role role = service.getRoleByRoleId(roleId);
		return new ResponseEntity<Role>(role,HttpStatus.OK);
	}
	
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = service.getUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("users/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable("userId") int userId){
		User user = service.getUserByUserId(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u = service.createUser(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	@PutMapping("users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User user){
		User updatedUser = service.updateUser(userId, user);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId){
		String message;
		boolean status = service.deleteUser(userId);
		if(status) {
			message = "User (UserId="+userId+") has been deleted successfully";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			message = "Error while deleting User(UserId="+userId+") from database";
			return new ResponseEntity<String>(message,HttpStatus.EXPECTATION_FAILED);
		}
	}
}

