package org.example.miniprojectspring.service;

import org.example.miniprojectspring.model.entity.AppUser;
import org.example.miniprojectspring.model.entity.AppUserDTO;
import org.example.miniprojectspring.model.entity.CustomUserDetail;
import org.example.miniprojectspring.model.request.AppUserRequest;
import org.example.miniprojectspring.repository.AppUserRepository;
import org.example.miniprojectspring.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUserDTO appUserDTO = appUserRepository.findByEmail(email);
        return new CustomUserDetail(appUserDTO);
    }

    @Override
    public AppUserDTO createUser(AppUserRequest appUserRequest) {
        return appUserRepository.saveUser(appUserRequest);
    }
}