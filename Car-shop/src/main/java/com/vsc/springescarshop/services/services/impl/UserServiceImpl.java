package com.vsc.springescarshop.services.services.impl;

import com.vsc.springescarshop.data.models.User;
import com.vsc.springescarshop.data.repositories.UserRepository;
import com.vsc.springescarshop.exeption.InvalidEntityException;
import com.vsc.springescarshop.services.models.LoginServiceModel;
import com.vsc.springescarshop.services.models.UserRegisterServiceModel;
import com.vsc.springescarshop.services.services.UserService;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserRegisterServiceModel createUser(UserRegisterServiceModel registerUserModel) {
        userRepository.findByUsername(registerUserModel.getUsername()).ifPresent(user -> {
            throw new InvalidEntityException(String.format("User with username '%s' already exists!", user.getUsername()));
        });
        registerUserModel.setPassword(passwordEncoder.encode(registerUserModel.getPassword()));
        User user = mapper.map(registerUserModel, User.class);
        user.setCreated(LocalDateTime.now());
        user.setRole(registerUserModel.getRoles());
        userRepository.saveAndFlush(user);
        return registerUserModel;
    }

    @SneakyThrows
    @Override
    public LoginServiceModel loginUser(LoginServiceModel loginServiceModel) {
        Optional<User> user = userRepository.findByUsername(loginServiceModel.getUsername());

        if (user.isEmpty()) {
            throw new InvalidEntityException
                    (String.format("User with username %s does not exist!", loginServiceModel.getUsername()));
        }
        boolean pass = passwordEncoder.matches(loginServiceModel.getPassword(), user.get().getPassword());
        if (!pass) {
            throw new IllegalArgumentException("Wrong password!");
        }
        LoginServiceModel loginModel = mapper.map(user.get(), LoginServiceModel.class);
        loginModel.setRoles(new ArrayList<>(user.get().getRole()).get(0).toString());
        return loginModel;
    }


    @Override
    public boolean equalPassword(String password, String confirmPassword) {
//        if (!password.equals(confirmPassword)) {
//            return false;
//        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        User user1 = user.get();
        return user.get();
    }
}
