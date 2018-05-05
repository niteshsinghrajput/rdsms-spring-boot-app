package com.rdsms.service;

import java.util.List;
import com.rdsms.entity.Role;
import com.rdsms.entity.User;

public interface IRdsmsService {
	
	//Role
	List<Role> getRoles();
	Role createRole(Role role);
	Role updateRole(int roleId, Role role);
	Role getRoleByRoleId(int roleId);
	boolean deleteRole(int roleId);
	
	//User
	List<User> getUsers();
	User createUser(User user);
	User updateUser(int userId, User user);
	User getUserByUserId(int userId);
	boolean deleteUser(int userId);
}
