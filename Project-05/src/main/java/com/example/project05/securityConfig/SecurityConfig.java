package com.example.project05.securityConfig;

import com.example.project05.common.UserRoleEnum;
import com.example.project05.service.UserService;
import com.example.project05.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserServiceImpl userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    // 定义一个名为configure的方法，该方法接收一个HttpSecurity对象作为参数，并抛出Exception异常
    protected void configure(HttpSecurity http) throws Exception {
        // 使用HttpSecurity对象的authorizeRequests方法，开始配置哪些URL需要哪些权限
        http.authorizeRequests()
                // 匹配所有以/admin/开头的URL，这些URL只有拥有"admin"角色的用户才能访问
                .antMatchers("/admin/**")
                .hasRole(UserRoleEnum.ADMIN.getUserRole())
                // 匹配所有以/user/开头的URL，这些URL只有拥有"admin"或"user"角色的用户才能访问
                .antMatchers("/user/**")
                .access("hasAnyRole(UserRoleEnum.ADMIN.getUserRole(),UserRoleEnum.USER.getUserRole())")
                // 匹配所有以/dba/开头的URL，这些URL只有拥有"dba"角色的用户才能访问
                .antMatchers("/dba/**")
                .hasRole(UserRoleEnum.DBA.getUserRole())
                // 匹配所有以/login/开头的URL，这些URL所有用户都可以访问
                .antMatchers("/login/**")
                .permitAll()
                // 匹配所有其他URL，这些URL只有经过身份验证的用户才能访问
                .anyRequest()
                .authenticated()
                // 结束权限配置，开始配置登录相关设置
                .and()
                // 配置表单登录，指定登录页、登录处理URL、用户名参数、密码参数、登录成功后的默认跳转页以及登录失败后的跳转页
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")
                .failureUrl("/login")
                // 结束登录配置，开始配置CSRF（跨站请求伪造）防护设置，这里禁用了CSRF防护
                .and()
                .csrf().disable();
    }

    /**
     * 静态资源设置
     */
    @Override
    public void configure(WebSecurity webSecurity) {
        //不拦截静态资源,所有用户均可访问的资源
        webSecurity.ignoring().antMatchers(
                "/",
                "/css/**",
                "/js/**",
                "/images/**",
                "/layui/**"
        );
    }
}
