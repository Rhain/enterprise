package com.rhain.enterprise.dao;

import com.rhain.enterprise.model.User;
import com.rhain.enterprise.model.UserIdentity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserDao {

    int insert(@Param("user")User user);

    void deleteByUsername(String username);

    List<UserIdentity> selectUsers();

    User getByUsername(String username);

    User getByUserId(Integer userId);

    int update(@Param("id")Integer id, @Param("username")String username, @Param("phone")String phone, @Param("updateAt")Date updateAt);
}
