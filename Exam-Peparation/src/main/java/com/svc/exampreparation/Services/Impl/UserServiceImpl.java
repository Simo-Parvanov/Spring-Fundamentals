package com.svc.exampreparation.Services.Impl;

import com.svc.exampreparation.Date.Reposiroties.UserRepository;
import com.svc.exampreparation.Date.User;
import com.svc.exampreparation.Services.Models.UserLoginServiceModel;
import com.svc.exampreparation.Services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void userLogin(UserLoginServiceModel loginServiceModel) {
       Optional<User> user = userRepository.findByUsername(loginServiceModel.getUsername());
       String userPass = null;
       if (user.isPresent()){
           userPass = user.get().getPassword();
       }
        boolean pass = passwordEncoder.matches(loginServiceModel.getPassword(), userPass);
        if (!pass) {
            throw new IllegalArgumentException("Wrong username or password!");
        }
    }
}
