package com.cipstore.user.service;

import com.cipstore.user.domain.User;
import com.cipstore.user.dto.LoginRequestDto;
import com.cipstore.user.dto.Response;
import com.cipstore.user.dto.SignupRequestDto;
import com.cipstore.user.dto.UserDto;
import com.cipstore.user.repository.UserRepository;
import com.cipstore.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void loginSuccess() {

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setName("test");
        user.setPassword("****");
        user.setId(1L);

        ModelMapper mapper = new ModelMapper();
        UserDto userDto = mapper.map(user, UserDto.class);

        Mockito.when(userRepository.findByEmailAndPassword(Mockito.anyString(),
                Mockito.anyString()))
                .thenReturn(user);

        Mockito.when(modelMapper.map(user,
                UserDto.class))
                .thenReturn(userDto);

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setEmail("test@gmail.com");
        loginRequestDto.setPassword("****");
        Response response = userService.login(loginRequestDto);
        assert response.getStatusCode().equals(HttpStatus.OK.toString());
    }

    @Test
    void loginFailure() {

        Mockito.when(userRepository.findByEmailAndPassword(Mockito.anyString(),
                Mockito.anyString()))
                .thenReturn(null);

        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setEmail("test@gmail.com");
        loginRequestDto.setPassword("****");
        Response response = userService.login(loginRequestDto);
        assert response.getStatusCode().equals(HttpStatus.UNAUTHORIZED.toString());
    }

    @Test
    void signupSuccess() {

        User user = new User();
        user.setEmail("test@gmail.com");
        user.setName("test");
        user.setPassword("****");
        user.setId(1L);

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(user);

        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setEmail("test@gmail.com");
        signupRequestDto.setName("test");
        signupRequestDto.setPassword("****");
        Response response = userService.signup(signupRequestDto);
        assert response.getStatusCode().equals(HttpStatus.OK.toString());
    }

}


