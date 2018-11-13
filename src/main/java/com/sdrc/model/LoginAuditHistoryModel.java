package com.sdrc.model;

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
public class LoginAuditHistoryModel {
	
	private long loginAuditId;
	
	private Timestamp loggedInDateTime;
	
	private Timestamp loggedOutDateTime;
	
	private String userIpAddress;
	
	private String userAgent;
	
	private boolean isLoggedIn;

}
