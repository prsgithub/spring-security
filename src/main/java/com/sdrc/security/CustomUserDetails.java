package com.sdrc.security;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sdrc.domain.UserAccount;
import com.sdrc.model.UserModel;
import com.sdrc.repository.UserAccountDetailsRepository;

/**
 * @author Subham Ashish(subham@sdrc.co.in) Created Date:06-Jul-2018 1:26:33 PM
 */
@Component
public class CustomUserDetails implements UserDetailsService {


	@Autowired
	private UserAccountDetailsRepository userAcRepository;

	@Override
	@Transactional
	public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {

		UserAccount user = userAcRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password !");
		}

		Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		
		/**
		 * As one user can have multiple roles
		 */
		Set<Integer> roleIds = new HashSet<>();

		Set<String> roles = new HashSet<>();
		/**
		 * Adding authority
		 * like @PreAuthorize("hasAuthority('feature_HAVING_permission')")
		 * 
		 */

		/*userAreaMapping.forEach(userArea -> {

			List<UserRoleFeaturePermissionMapping> userRoleFeaturePermissionMappings = userArea
					.getUserRoleFeaturePermissionMappings();

			userRoleFeaturePermissionMappings.forEach(userRoleFeaturePermission -> {

				RoleFeaturePermissionScheme roleFeaturePermissionScheme = userRoleFeaturePermission
						.getRoleFeaturePermissionScheme();

				*//**
				 * addin role ids here
				 *//*
				roleIds.add(roleFeaturePermissionScheme.getRole().getRoleId());

				*//**
				 * adding role name here
				 *//*
				roles.add(roleFeaturePermissionScheme.getRole().getRoleName());
				
//				LOGGER.info("<<Authorites : << : " + roleFeaturePermissionScheme.getFeaturePermissionMapping()
//						.getFeature().getFeatureName().concat(",").concat(roleFeaturePermissionScheme
//								.getFeaturePermissionMapping().getPermission().getPermissionName()));

				*//**
				 * adding authority
				 *//*
				grantedAuthority.add(new SimpleGrantedAuthority(

						roleFeaturePermissionScheme.getFeaturePermissionMapping().getFeature().getFeatureName().concat("_HAVING_")
								.concat(roleFeaturePermissionScheme.getFeaturePermissionMapping()
										.getPermission().getPermissionName())
										

				));
				
				areas.add(userRoleFeaturePermission.getUserAreaMapping().getArea());
			});

		});*/
		
		return new UserModel(user.getUsername(), user.getPassword(), user.isEnabled(), !user.isExpired(),
				!user.isCredentialexpired(), !user.isLocked(), grantedAuthority, (int)user.getAccountId(), 
				roleIds, roles,null,null);

	}

}
