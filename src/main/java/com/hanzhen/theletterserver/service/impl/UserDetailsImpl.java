package com.hanzhen.theletterserver.service.impl;

import com.hanzhen.theletterserver.entity.Role;
import com.hanzhen.theletterserver.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class UserDetailsImpl extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    public UserDetailsImpl(User user) {
        if(user != null)
        {
            this.setUserId(user.getUserId());
            this.setName(user.getName());
            this.setPassword(user.getPassword());
            this.setGender(user.getGender());
//            this.setPhone(user.getPhone());
            this.setRoles(user.getRoles());
            this.setEmail(user.getEmail());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Role> roles = this.getRoles();
        if(roles != null)
        {
            for (Role role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
