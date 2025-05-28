package com.hotel.reservations.service;

import com.hotel.reservas.dto.UserDTO;
import com.hotel.reservas.entity.User;
import com.hotel.reservas.exception.UserNotFoundException;
import com.hotel.reservas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // find user id by email
    @Override
    public Integer findIdByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"))
                .getUserId();
    }

    // regis a new user
    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setRole(User.Role.valueOf(userDTO.getRole())); // string role to enum
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // encryptthe password

        // saving datas user
        User savedUser = userRepository.save(user);
        userDTO.setUserId(savedUser.getUserId());
        return userDTO;
    }

    // authentication of user
    @Override
    public Optional<UserDTO> authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.get().getUserId());
            userDTO.setFirstName(user.get().getFirstName());
            userDTO.setLastName(user.get().getLastName());
            userDTO.setEmail(user.get().getEmail());
            userDTO.setPhone(user.get().getPhone());
            userDTO.setRole(user.get().getRole().name()); // enum to string
            return Optional.of(userDTO);
        }
        return Optional.empty(); // if no user found or credentials dont match
    }

    // update a user details
    @Override
    public UserDTO updateUser(Integer userId, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setRole(User.Role.valueOf(userDTO.getRole())); //string role to enum

            userRepository.save(user); // save changes to db
            return userDTO;
        }
        throw new UserNotFoundException("User with ID " + userId + " not found");
    }
}
