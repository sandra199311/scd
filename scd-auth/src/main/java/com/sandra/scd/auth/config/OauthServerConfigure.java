package com.sandra.scd.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author: sandra
 * @Description: OauthServer配置
 * @Date: 2019/9/19 11:22
 **/
@Configuration
@EnableAuthorizationServer
public class OauthServerConfigure extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    /**
     *配置客户端信息
     * @param clients
     * @throws Exception
     */

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {

        //保存内存中
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
                .and()
                .withClient("client1")
                .secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token", "password", "authorization_code")
                .scopes("server");

        //从数据库中查询客户端详情
//        clients.withClientDetails(this.clientDetails());
    }

    /**
     * 配置授权（authorization）、令牌（token）的访问端点和令牌服务(token services)，还有token的存储方式(tokenStore)
     * 默认情况下，token、authorizationCode都存放在内存中
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

//        endpoints.authorizationCodeServices(new JdbcAuthorizationCodeServices(this.dataSource));
//        endpoints.tokenStore(this.tokenStore()).reuseRefreshTokens(false);
        // 只有配置了authenticationManager才能开启密码模式
        endpoints.authenticationManager(this.authenticationManager);
        endpoints.userDetailsService(this.userDetailsService);
    }

    /**
     * 配置令牌端点(Token Endpoint)的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

//    private TokenStore tokenStore() {
//        // token保存在数据库中
////        return new JdbcTokenStore(this.dataSource);
//        // token保存在内存中
//        return new InMemoryTokenStore();
//    }

}
