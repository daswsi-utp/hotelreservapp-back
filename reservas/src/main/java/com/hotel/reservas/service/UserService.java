package com.hotel.reservas.service;

import com.hotel.reservas.dto.UserDTO;

import java.util.Optional;

public interface UserService {

    //method to register a nwe user
    UserDTO registerUser(UserDTO userDTO);

    Optional<UserDTO> authenticateUser(String email, String password);

    Integer findIdByEmail(String email);

    UserDTO updateUser(Integer userId, UserDTO userDTO);
}
