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
	Role getRoleByRoleId(Long roleId);
	Role createRole(Role role);
	Role updateRole(Long roleId,Role role);
	boolean deleteRole(Long roleId);
	
	//User
	List<User> getUsers();
	User createUser(User user);
	User updateUser(Long userId, User user);
	User getUserByUserId(Long userId);
	boolean deleteUser(Long userId);
	
}
