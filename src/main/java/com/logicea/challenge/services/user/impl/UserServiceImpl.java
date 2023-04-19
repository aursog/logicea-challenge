package com.logicea.challenge.services.user.impl;

import com.logicea.challenge.dto.user.UserDto;
import com.logicea.challenge.dto.user.mapper.UserMapper;
import com.logicea.challenge.exceptions.NotFoundRecordException;
import com.logicea.challenge.repository.UserRepository;
import com.logicea.challenge.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto loginUser(String username, String password) throws NotFoundRecordException {
        return userRepository.findByUsername(username)
                .map(UserMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NotFoundRecordException("User with username -> " + username + " not found"));
    }
}
