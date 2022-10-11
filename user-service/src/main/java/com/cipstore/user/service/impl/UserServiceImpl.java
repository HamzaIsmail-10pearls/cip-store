package com.cipstore.user.service.impl;

import com.cipstore.user.domain.User;
import com.cipstore.user.dto.LoginRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.SignupRequestDto;
import com.cipstore.user.dto.UserDto;
import com.cipstore.user.repository.UserRepository;
import com.cipstore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Response login(LoginRequestDto createOrderRequestDto) {
        User user = userRepository.findByEmailAndPassword(createOrderRequestDto.getEmail(), createOrderRequestDto.getPassword());
        if (user == null) {

            return Response.builder()
                    .statusCode(HttpStatus.UNAUTHORIZED.toString())
                    .statusMessage("UnAuthorized")
                    .build();
        }

        UserDto userDto = modelMapper.map(user, UserDto.class);
        return Response
                .builder()
                .statusCode(HttpStatus.OK.toString())
                .statusMessage("Success")
                .data(userDto)
                .build();
    }

    @Override
    public Response signup(SignupRequestDto signupRequestDto) {

        User user = new User();
        user.setEmail(signupRequestDto.getEmail());
        user.setName(signupRequestDto.getName());
        user.setPassword(signupRequestDto.getPassword());
        user = userRepository.save(user);

        return Response.builder()
                .data(user.getId())
                .statusCode(HttpStatus.OK.toString())
                .statusMessage("Success")
                .build();
    }
}
