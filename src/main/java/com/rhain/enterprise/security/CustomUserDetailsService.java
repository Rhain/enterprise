package com.rhain.enterprise.security;

import com.rhain.enterprise.dao.RoleDao;
import com.rhain.enterprise.dao.UserDao;
import com.rhain.enterprise.dao.UserRolesDao;
import com.rhain.enterprise.model.Role;
import com.rhain.enterprise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRolesDao userRolesDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByUsername(username);
        setUserRoles(user);
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer userId){
        User user = userDao.getByUserId(userId);
        setUserRoles(user);
        return UserPrincipal.create(user);
    }

    private void setUserRoles(User user) {
        List<Role> roles = roleDao.getAll();
        List<Integer> userRoleIds = userRolesDao.getRoleIdsByUserId(user.getId());
        Set<Role> userRoles = new HashSet<>();
        for (Integer userRoleId : userRoleIds) {
            for (Role role : roles) {
                if(userRoleId.equals(role.getId())){
                    userRoles.add(role);
                }
            }
        }
        user.setRoles(userRoles);
    }
}
