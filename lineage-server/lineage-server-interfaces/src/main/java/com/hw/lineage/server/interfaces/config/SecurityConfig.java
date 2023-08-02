/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.interfaces.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hw.lineage.server.application.service.UserService;
import com.hw.lineage.server.interfaces.enhanced.EnhancedParametersFilter;
import com.hw.lineage.server.interfaces.result.Result;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static com.hw.lineage.server.interfaces.result.ResultMessage.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @description: SecurityConfig
 * @author: HamaWhite
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private static final String[] AUTH_WHITE_LIST = {
            // for swagger
            "/swagger-resources/**",
            "/v3/**",
            "/swagger-ui/**",
            // for knife4j
            "/doc.html",
            "/webjars/**",
            // fow lineage web
            "/",
            "/favicon.ico",
            "/static/**",
            // currently only APIs under plugins require login and authentication.
            "/tasks/**",
            "/catalogs/**",
            "/functions/**",
            "/storages/**",
            "/users/**",
            "/roles/**",
            "/permissions/**",
            "/audits/**"
    };

    @Resource
    private UserService userService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // override the default UserDetailsService
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                // unencrypted password
                return rawPassword.toString();
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equalsIgnoreCase(encodedPassword);
            }
        });
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITE_LIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .successHandler((req, resp, authentication) -> writeSecurityResult(resp,
                        Result.success(LOGIN_SUCCESS, authentication.getPrincipal())))
                .failureHandler((req, resp, e) -> writeSecurityResult(resp, Result.error(optimizeFailureMessage(e))))
                .and()
                .logout()
                .logoutSuccessHandler(
                        (req, resp, authentication) -> writeSecurityResult(resp, Result.success(LOGOUT_SUCCESS)))
                .permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        (req, resp, authException) -> writeSecurityResult(resp, Result.error(NOT_LOGGED_IN)));

        // add the userId parameter in the request parameter
        http.addFilterBefore(new EnhancedParametersFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    private String optimizeFailureMessage(AuthenticationException e) {
        if (e instanceof AccountExpiredException) {
            return USER_ACCOUNT_EXPIRED;
        } else if (e instanceof BadCredentialsException) {
            return USER_ACCOUNT_OR_PASSWORD_ERROR;
        } else if (e instanceof CredentialsExpiredException) {
            return USER_PASSWORD_EXPIRED;
        } else if (e instanceof DisabledException) {
            return USER_ACCOUNT_DISABLE;
        } else if (e instanceof LockedException) {
            return USER_ACCOUNT_LOCKED;
        } else {
            return e.getMessage();
        }
    }

    private void writeSecurityResult(HttpServletResponse resp, Result<?> result) throws IOException {
        resp.setContentType(APPLICATION_JSON_VALUE);
        try (PrintWriter out = resp.getWriter()) {
            out.write(new ObjectMapper().writeValueAsString(result));
            out.flush();
        }
    }
}
