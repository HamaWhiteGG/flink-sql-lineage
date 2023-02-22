package com.hw.lineage.server.application.dto;

import com.hw.lineage.server.application.dto.basic.RootDTO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @description: UserDTO
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class UserDTO extends RootDTO implements UserDetails {

    private Long userId;

    private String username;

    private String password;

    private Boolean locked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
