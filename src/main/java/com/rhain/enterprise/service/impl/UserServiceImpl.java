package com.rhain.enterprise.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.dao.RoleDao;
import com.rhain.enterprise.dao.UserDao;
import com.rhain.enterprise.dao.UserRolesDao;
import com.rhain.enterprise.exception.ResourceNotFoundException;
import com.rhain.enterprise.model.Role;
import com.rhain.enterprise.model.RoleName;
import com.rhain.enterprise.model.User;
import com.rhain.enterprise.model.UserIdentity;
import com.rhain.enterprise.payload.SignUpRequest;
import com.rhain.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    @Transactional
    public UserIdentity addUser(SignUpRequest signUpRequest) {
        Role role = roleDao.getByName(signUpRequest.getRole());
        if(role == null){
            throw new ResourceNotFoundException("role name", "role", signUpRequest.getRole());
        }
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getPhone());
        userDao.insert(user);
        userRolesDao.insertUserRole(user.getId(), role.getId());
        return new UserIdentity(user, role.getName());
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteByUsername(username);
    }

    @Override
    public PageInfo<UserIdentity> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserIdentity> users = userDao.selectUsers();

        return new PageInfo<UserIdentity>(users);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    @Transactional
    public void updateUser(UserIdentity user) {
        Role role = roleDao.getByName(user.getRole());
        if(role == null){
            throw new ResourceNotFoundException("role name", "role", user.getRole());
        }
        userDao.update(user.getId(),user.getUsername(), user.getPhone(), new Date());
        userRolesDao.updateUserRole(user.getId(), role.getId());
    }
}
