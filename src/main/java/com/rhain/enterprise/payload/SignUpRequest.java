package com.rhain.enterprise.payload;

import com.rhain.enterprise.model.RoleName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpRequest {
    @NotNull
    @Size(min = 6, max=15)
    private String username;
    @NotNull
    @Size(min = 6, max=200)
    private String password;

    private String phone;

    private RoleName role;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
