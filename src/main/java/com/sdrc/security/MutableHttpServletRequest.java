package com.sdrc.security;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Subham Ashish(subham@sdrc.co.in) 
 * 
 * This class is added to add authorization header in the request url oauth/token
 */
public class MutableHttpServletRequest extends HttpServletRequestWrapper {

//	@Value("${oauth2.client.id}")
//	private String clientId;
//	
//	@Value("${oauth2.client.secret}")
//	private String clientSecrte;
	
	private final Map<String, String> customHeaders;

	public MutableHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.customHeaders = new HashMap<String, String>();
	}

//	public void setAuthHeaders() {
//
//		String credentials = clientId+":"+clientSecrte;
//		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		headers.add("Authorization", "Basic " + encodedCredentials);
//
//	}

	public void putHeader(String name, String value) {
		this.customHeaders.put(name, value);
	}

	public String getHeader(String name) {
		/*
		 *  check the custom headers first
		 */
		String headerValue = customHeaders.get(name);

		if (headerValue != null) {
			return headerValue;
		}
		
		// else return from into the original wrapped object
		return ((HttpServletRequest) getRequest()).getHeader(name);
	}

	public Enumeration<String> getHeaderNames() {
		/*
		 * create a set of the custom header names
		 */
		Set<String> set = new HashSet<String>(customHeaders.keySet());

		// now add the headers from the wrapped request object
		@SuppressWarnings("unchecked")
		Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
		while (e.hasMoreElements()) {
			// add the names of the request headers into the list
			String n = e.nextElement();
			set.add(n);
		}
		// create an enumeration from the set and return
		return Collections.enumeration(set);
	}

}
