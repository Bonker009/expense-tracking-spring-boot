package org.example.miniprojectspring.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.miniprojectspring.model.entity.AppUserDTO;
import org.example.miniprojectspring.model.request.AppUserRequest;
import org.example.miniprojectspring.model.request.AuthRequest;
import org.example.miniprojectspring.model.response.ApiResponse;
import org.example.miniprojectspring.model.response.AuthResponse;
import org.example.miniprojectspring.security.JwtService;
import org.example.miniprojectspring.service.AppUserService;
import org.example.miniprojectspring.service.MailSenderService;
import org.example.miniprojectspring.service.OptGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auths")
@RestController
@AllArgsConstructor
public class AuthController {
    private final AppUserService appUserService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    private final MailSenderService mailSenderService;


    @PutMapping("/verify")
    public String verify() {
        return "verify";
    }

    @PutMapping("/forget")
    public String forget() {
        return "forget";
    }

    @PostMapping("resend")
    public String resend() {
        return "resend";
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody AppUserRequest appUserRequest) {
        String encodedPassword = passwordEncoder.encode(appUserRequest.getPassword());
        appUserRequest.setPassword(encodedPassword);
        AppUserDTO appUserDTO = appUserService.createUser(appUserRequest);

        ApiResponse<AppUserDTO> response = ApiResponse.<AppUserDTO>builder().message("Successfully Registered").code(201).
                status(HttpStatus.CREATED).payload(appUserDTO).build();
        System.out.println(appUserDTO);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        authenticate(authRequest.getEmail(), authRequest.getPassword());
        final UserDetails userDetails = appUserService.loadUserByUsername(authRequest.getEmail());
        final String token = jwtService.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse(token);
        mailSenderService.sendEmail(authRequest.getEmail(),OptGenerator.generateOTP(6));
        return ResponseEntity.ok(authResponse);
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            UserDetails userDetails = appUserService.loadUserByUsername(email);
            System.out.println("UserDetail : " + userDetails);
            if (userDetails == null) {
                throw new BadRequestException("User not found");
            }
            System.out.println("UserDetail is not null");
            System.out.println("Password : " + password);
            System.out.println("UserDetail password : " + userDetails.getPassword());
            System.out.println(passwordEncoder.matches(password, userDetails.getPassword()));
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Invalid password");
            }
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            System.out.println("Seyha");
        } catch (DisabledException e) {
            throw new Exception("User disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials", e);
        }
    }


}
