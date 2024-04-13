package org.example.miniprojectspring.service;

import org.example.miniprojectspring.model.entity.AppUserDTO;
import org.example.miniprojectspring.model.request.AppUserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public interface AppUserService extends UserDetailsService {

    AppUserDTO createUser(AppUserRequest appUserRequest);


}
