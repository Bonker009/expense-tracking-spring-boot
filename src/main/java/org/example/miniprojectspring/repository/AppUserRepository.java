package org.example.miniprojectspring.repository;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.miniprojectspring.exception.UuidTypeHandler;
import org.example.miniprojectspring.model.entity.AppUser;
import org.example.miniprojectspring.model.entity.AppUserDTO;
import org.example.miniprojectspring.model.request.AppUserRequest;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AppUserRepository {
    @Results(id = "AppUserMapping", value = {
            @Result(property = "profileImage", column = "profile_image"),
            @Result(property = "userId", column = "user_id", jdbcType = JdbcType.OTHER, typeHandler = UuidTypeHandler.class)})

    @Select("""
            INSERT INTO users  VALUES (DEFAULT,DEFAULT,#{user.email} , #{user.password},#{user.profileImage}) RETURNING *
            """)
    AppUserDTO saveUser(@Param("user") AppUserRequest appUserRequest);

    @Select("""
            SELECT * FROM users WHERE email = #{email}
            """)
    @ResultMap("AppUserMapping")
    AppUserDTO findByEmail(@Param("email") String email);
}
