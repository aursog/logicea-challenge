package com.logicea.challenge.services.user;

import com.logicea.challenge.dto.user.UserDto;
import com.logicea.challenge.exceptions.NotFoundRecordException;

public interface UserService {
    UserDto loginUser(String username, String password) throws NotFoundRecordException;
}
