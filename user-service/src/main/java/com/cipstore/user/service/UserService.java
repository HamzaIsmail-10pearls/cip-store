package com.cipstore.user.service;

import com.cipstore.user.dto.LoginRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.SignupRequestDto;

public interface UserService {

    Response login(LoginRequestDto createOrderRequestDto);

    Response signup(SignupRequestDto signupRequestDto);
}
