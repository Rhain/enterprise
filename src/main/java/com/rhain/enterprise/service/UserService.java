package com.rhain.enterprise.service;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.User;
import com.rhain.enterprise.model.UserIdentity;
import com.rhain.enterprise.payload.SignUpRequest;

public interface UserService {
    UserIdentity addUser(SignUpRequest signUpRequest);

    void deleteUser(String username);

    PageInfo<UserIdentity> findAllUser(int pageNum, int pageSize);

    User getByUsername(String username);

    void updateUser(UserIdentity user);
}
