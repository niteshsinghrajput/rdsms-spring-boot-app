package com.rdsms.service;

import java.util.List;
import com.rdsms.entity.Role;
import com.rdsms.entity.User;

public interface IRdsmsService {
	
	//Role
	List<Role> getRoles();
	Role createRole(Role role);
	Role updateRole(Long roleId, Role role);
	Role getRoleByRoleId(Long roleId);
	boolean deleteRole(Long roleId);
	
	//User
	List<User> getUsers();
	User createUser(User user);
	User updateUser(Long userId, User user);
	User getUserByUserId(Long userId);
	boolean validateUserName(User user);
	boolean validateEmail(User user);
	boolean deleteUser(Long userId);
	User getUserByEmail(String email);
}
