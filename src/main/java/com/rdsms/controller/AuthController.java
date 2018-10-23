package com.rdsms.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rdsms.entity.Role;
import com.rdsms.entity.RoleName;
import com.rdsms.entity.User;
import com.rdsms.exception.AppException;
import com.rdsms.payload.ApiResponse;
import com.rdsms.payload.JwtAuthenticationResponse;
import com.rdsms.payload.LoginRequest;
import com.rdsms.repository.RoleRepository;
import com.rdsms.repository.UserRepository;
import com.rdsms.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @SuppressWarnings("unchecked")
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        if(userRepository.existsByUserName(user.getUserName())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user1 = new User(user.getName(),user.getEmail(),user.getUserName(), user.getPassword(),
        				user.getMobile(), user.getAddress(), user.getCity(), user.getDistrict(), 
        				user.getPostalCode(),true);

        user1.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new AppException("User Role not set."));

        user1.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user1);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUserName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
