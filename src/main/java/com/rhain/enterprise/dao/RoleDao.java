package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.Role;
import com.rhain.enterprise.model.RoleName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {
    Role getByName(RoleName roleName);

    List<Role> getAll();
}
