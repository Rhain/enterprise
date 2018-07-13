package com.rhain.enterprise.payload;

import java.util.List;

public class UserSummary {
    private Boolean success;
    private Integer id;
    private String username;
    private String phone;
    private List<String> roles;

    public UserSummary(Boolean success, Integer id, String username, String phone, List<String> rolse) {
        this.success = success;
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.roles = rolse;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
