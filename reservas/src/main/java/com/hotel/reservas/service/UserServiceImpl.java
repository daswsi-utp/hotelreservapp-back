package com.hotel.reservas.service;

import com.tuapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer findIdByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow().getUserId();
    }
}