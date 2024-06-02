package com.example.travelAgency.security;

import com.example.travelAgency.entity.Role;
import com.example.travelAgency.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@AllArgsConstructor
public class MyUserDetails implements UserDetails {

    private User userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> userRoles = userEntity.getRole();
        Set<SimpleGrantedAuthority> listOfAllAccess = new HashSet<>();
        for (Role role : userRoles) {
            listOfAllAccess.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return listOfAllAccess;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
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
