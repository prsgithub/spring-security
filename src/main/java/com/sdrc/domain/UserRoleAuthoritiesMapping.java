package com.sdrc.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class UserRoleAuthoritiesMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleAuthoritiesMappingId;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	private UserAccount user;
	
	@ManyToOne
	@JoinColumn(name="role_authorities_mapping_id_fk", nullable = false)
	private RoleAuthoritiesMapping roleAuthoritiesMapping;

}
