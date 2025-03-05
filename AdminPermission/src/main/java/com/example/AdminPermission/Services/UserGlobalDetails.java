package com.example.AdminPermission.Services;

import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;



public class UserGlobalDetails implements UserDetails {
    private final String role;
    private final String email;
    private final String password;
    private final boolean isBlocked;
    public UserGlobalDetails(Admin admin) {
        this.role = admin.getRole();
        this.email = admin.getEmail();
        this.password = admin.getPassword();
        this.isBlocked = admin.isBlocked();
    }

    public UserGlobalDetails(User user) {
        this.role = user.getRole();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.isBlocked = user.isBlocked();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
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
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return isBlocked;
    }
}
