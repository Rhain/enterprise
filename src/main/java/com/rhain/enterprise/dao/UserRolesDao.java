package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface UserRolesDao {

    List<Integer> getRoleIdsByUserId(Integer userId);

    void insertUserRole(@Param("userId")Integer userId, @Param("roleId")Integer roleId);

    int updateUserRole(@Param("userId")Integer userId, @Param("roleId")Integer roleId);

    int getRoleIdByUserId(Integer userId);
}
