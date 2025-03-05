package com.example.demo.service;

import java.util.Collection;
import java.util.Collections; 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Admin;

public class AdminDetailsSerivice implements UserDetails {

    private String email; // Using email as username
    private String password;

    public AdminDetailsSerivice(Admin admin) {
        this.email = admin.getEmail(); // Set email from Admin
        this.password = admin.getPassword(); // Set password from Admin
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return an empty list since there are no roles defined
        return Collections.emptyList(); // No authorities/roles
    }

    @Override
    public String getPassword() {
        return password; 
    }

    @Override
    public String getUsername() {
        return email; 
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
