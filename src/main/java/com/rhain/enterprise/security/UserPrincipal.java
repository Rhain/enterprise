package com.rhain.enterprise.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rhain.enterprise.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private Integer id;

    private String username;

    private String phone;
    private List<String> roles;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String username, String password, String phone,
                         Collection<? extends GrantedAuthority> authorities, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.authorities = authorities;
        this.roles = roles;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        List<String> roles = user.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                authorities,
                roles
        );
    }

    public Integer getId() {
        return id;
    }

    public String getPhone(){
        return phone;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public List<String> getRoles() {
        return roles;
    }

}
