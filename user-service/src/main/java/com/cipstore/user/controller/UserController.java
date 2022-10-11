package com.cipstore.user.controller;

import com.cipstore.user.dto.LoginRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.SignupRequestDto;
import com.cipstore.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Login", notes = "Login user")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public @ResponseBody
    Response login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto);
    }


    @ApiOperation(value = "Sign Up", notes = "Sign up user")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signup")
    public @ResponseBody
    Response login(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }
}
