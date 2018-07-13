package com.rhain.enterprise.model;

import java.util.Date;

public class UserIdentity {
    private Integer id;
    private String username;
    private String phone;
    private Date updateAt;
    private RoleName role;

    public UserIdentity() {}

    public UserIdentity(User user, RoleName role) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.updateAt = user.getUpdateAt();
        this.role = role;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
