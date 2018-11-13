package com.sdrc.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sdrc.model.UserAccountModel;
import com.sdrc.model.UserModel;

/**
 * @author Subham Ashish(subham@sdrc.co.in)
 * 
 */
@RestController
public class PrincipalResource {
 
    @RequestMapping(value="/user",method = RequestMethod.GET)
    @Transactional
    public UserModel oauth(Principal principal) {
    	
       
    	
    	//UserAccountModel user  =  (UserAccountModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		//HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		/*LoginAuditHistory audit = new LoginAuditHistory();
		audit.setLoggedIn(true);
		audit.setUsername(user.getUsername());
		audit.setUserIpAddress(request.getRemoteAddr());
		audit.setUserAgent(request.getHeader("User-Agent"));*/
		//audit.setLoggedInDateTime(new java.sql.Date());

		//UserAccount userDomain = new UserAccount();
		//userDomain.setAccountId(user.getAccountId());
		
		//audit.setUser(userDomain);


		

		//audit = loginAuditRepository.save(audit);

        return (UserModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    

   
    
}
