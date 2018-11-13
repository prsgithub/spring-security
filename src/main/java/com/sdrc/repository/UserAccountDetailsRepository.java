package com.sdrc.repository;

import org.springframework.data.repository.RepositoryDefinition;

import com.sdrc.domain.UserAccount;

@RepositoryDefinition(domainClass=UserAccount.class,idClass=Long.class)
public interface UserAccountDetailsRepository {
	
	UserAccount findByUsername(String username);
}
