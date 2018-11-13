package com.sdrc.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class LoginAuditHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loginAuditId;
	
	@Column
	private Timestamp loggedInDateTime;
	
	@Column
	private Timestamp loggedOutDateTime;
	
	@Column
	private String userIpAddress;
	
	@Column
	private String userAgent;
	
	@Column
	private boolean isLoggedIn;

}
