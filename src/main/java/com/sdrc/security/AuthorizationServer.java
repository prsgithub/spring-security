package com.sdrc.security;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;



@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	//@Autowired
	//UserRepository userRepository;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	UserAuthenticationProvider userAuthenticationProvider;
	
	@Autowired
	CustomUserDetails customUserDetails;
	
/*	@Bean
	public JwtAccessTokenConverter tokenConverter() {
//		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
//		tokenConverter.setSigningKey("skaterik123");
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(
				new ClassPathResource("keystore.jks"), "skaterik123".toCharArray()).getKeyPair("selfsigned");
		tokenConverter.setKeyPair(keyPair);
		return tokenConverter;
	}*/
	
	/*@Bean
	public TokenStore tokenStore() { 
	    return new InMemoryTokenStore(); 
	}*/
	@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints.tokenStore(tokenStore())
		.authenticationManager(authenticationManager)
		.userDetailsService(customUserDetails);//added to get new access token with refresh token
	}
	

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security)
			throws Exception {
		security.checkTokenAccess("permitAll()");
		/*
		 * added to call custom filter before BasicAuthenticationFilter
		 */
		security.addTokenEndpointAuthenticationFilter(new RequestLoggingInterceptor());
	
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		
		clients.jdbc(dataSource);
		
		/*clients.inMemory().withClient("web").secret("pass")
		.authorizedGrantTypes("authorization_code",
				"password", "client_credentials", "implicit", "refresh_token")
		.scopes("read","write")
		.accessTokenValiditySeconds(300)
		.refreshTokenValiditySeconds(3000);*/
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.authenticationProvider(userAuthenticationProvider);
	}

	
}
