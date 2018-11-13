/**
 * 
 */
package com.sdrc.model;

import java.util.Collection;


import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * @author 
 */
public class UserModel extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4431662893129587625L;

	private Integer userId;

	private Set<Integer> roleIds;

	private Set<String> roles;

	private String name;

	private String emailId;

	/**
	 * *
	 * 
	 * @Description private constructors to use existing properties
	 */
	private UserModel(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

	}

	/***
	 * @Desription extra parameter has been passed here to be initialized and
	 *             return
	 */
	public UserModel(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			Integer userId,  Set<Integer> roleIds,
			Set<String> roles, String name, String emailId) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.userId = userId;
		this.roleIds = roleIds;
		this.roles = roles;
		this.name = name;
		this.emailId = emailId;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Set<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Integer> roleIds) {
		this.roleIds = roleIds;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
