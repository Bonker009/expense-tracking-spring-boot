package org.example.miniprojectspring.repository;

import org.apache.ibatis.annotations.*;
import org.example.miniprojectspring.model.entity.AppUser;
import org.example.miniprojectspring.model.entity.AppUserDTO;
import org.example.miniprojectspring.model.request.AppUserRequest;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface AppUserRepository {
    @Results(id = "AppUserMapping", value = {
            @Result(property = "profileImage", column = "profile_image")
    })
    @Select("""
            INSERT INTO users  VALUES (DEFAULT,#{user.email} , #{user.password},#{user.profileImage}) RETURNING *
            """)
    AppUserDTO saveUser(@Param("user") AppUserRequest appUserRequest);

    @Select("""
                    SELECT * FROM users WHERE email = #{email}
            """)
//    @ResultMap("AppUserMapping")
    AppUser findByEmail(@Param("email") String email);
}
