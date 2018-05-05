package com.rdsms.dao;

import java.util.List;
import com.rdsms.entity.Role;
import com.rdsms.entity.User;

/**
 * 
 * @author Nitesh
 *
 */
public interface IRdsmsDAO {
	
	//Role
	List<Role> getRoles();
	Role getRoleByRoleId(int roleId);
	Role createRole(Role role);
	Role updateRole(int roleId,Role role);
	boolean deleteRole(int roleId);
	
	//User
	List<User> getUsers();
	User createUser(User user);
	User updateUser(int userId, User user);
	User getUserByUserId(int userId);
	boolean deleteUser(int userId);
	
}
