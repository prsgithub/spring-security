package com.sdrc.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table
public class RoleAuthoritiesMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleAuthoritiesMappingId;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_date")
	private Timestamp updatedDate;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	
	@ManyToOne
	@JoinColumn(name="role_id_fk", nullable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="authorities_id_fk")
	private Authorities authorities;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserRoleAuthoritiesMapping> userRoleAuthoritiesMapping;
	
	
	

}
