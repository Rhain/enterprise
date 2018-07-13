package com.rhain.enterprise.payload;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.UserIdentity;

public class UsersResponse {
    private Boolean success;
    private PageInfo<UserIdentity> users;

    public UsersResponse(Boolean success, PageInfo<UserIdentity> users) {
        this.success = success;
        this.users = users;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public PageInfo<UserIdentity> getUsers() {
        return users;
    }

    public void setUsers(PageInfo<UserIdentity> users) {
        this.users = users;
    }
}
