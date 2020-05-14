package com.ipn.escom.covid.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccessTokenConverter accessTokenConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

    @Value("${spring.security.oauth.clientId}")
    private String clientId;

    @Value("${spring.security.oauth.clientSecret}")
    private String clientSecret;

    @Value("${spring.security.oauth.accessTokenValiditySeconds}")
    private int accessTokenValiditySeconds;

    @Value("${spring.security.oauth.refreshTokenValiditySeconds}")
    private int refreshTokenValiditySeconds;

    @Value("#{'${spring.security.oauth.scopes}'.split(',')}")
    private String[] scopes;

    @Value("#{'${spring.security.oauth.grantTypes}'.split(',')}")
    private String[] grantTypes;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() //
                .withClient(clientId) //
                .secret(passwordEncoder.encode(clientSecret)) //
                .accessTokenValiditySeconds(accessTokenValiditySeconds) //
                .refreshTokenValiditySeconds(refreshTokenValiditySeconds) //
                .scopes(scopes) //
                .authorizedGrantTypes(grantTypes);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(accessTokenConverter).tokenStore(tokenStore)
                .reuseRefreshTokens(false).authenticationManager(authenticationManager);
    }
}
