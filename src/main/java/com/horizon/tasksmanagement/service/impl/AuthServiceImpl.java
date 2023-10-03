package com.horizon.tasksmanagement.service.impl;

import com.horizon.tasksmanagement.dto.LoginDTO;
import com.horizon.tasksmanagement.dto.RegisterDTO;
import com.horizon.tasksmanagement.entity.Role;
import com.horizon.tasksmanagement.entity.User;
import com.horizon.tasksmanagement.exception.TaskAPIException;
import com.horizon.tasksmanagement.repository.RoleRepository;
import com.horizon.tasksmanagement.repository.UserRepository;
import com.horizon.tasksmanagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDTO registerDTO) {


        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new TaskAPIException(HttpStatus.BAD_REQUEST, "Username already exists.");
        }


        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new TaskAPIException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered!";
    }

    @Override
    public String login(LoginDTO loginDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(),
                loginDTO.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "Successfully logged in!";
    }


}
