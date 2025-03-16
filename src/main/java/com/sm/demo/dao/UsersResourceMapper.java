package com.sm.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.sm.demo.domain.UsersResource;

public interface UsersResourceMapper{
  public List<UsersResource> selectUserByUserPwd(@Param("username") String username,@Param("password") String password);
  
  public List<UsersResource> selectUserByUserPwdRoles(@Param("username") String username,@Param("password") String password,@Param("roles") String roles);
}
