package com.horizon.tasksmanagement.service;

import com.horizon.tasksmanagement.dto.LoginDTO;
import com.horizon.tasksmanagement.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);
}
