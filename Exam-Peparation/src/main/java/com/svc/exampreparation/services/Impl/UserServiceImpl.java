package com.svc.exampreparation.services.Impl;

import com.svc.exampreparation.date.reposiroties.UserRepository;
import com.svc.exampreparation.date.User;
import com.svc.exampreparation.services.models.UserLoginServiceModel;
import com.svc.exampreparation.services.UserService;
import com.svc.exampreparation.web.models.UserRegisterWebModel;
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
        if (user.isPresent()) {
            userPass = user.get().getPassword();
        }
        boolean pass = passwordEncoder.matches(loginServiceModel.getPassword(), userPass);
        if (!pass) {
            throw new IllegalArgumentException("Wrong username or password!");
        }
    }

    @Override
    public void register(UserRegisterWebModel userRegisterWebModel) {
        Optional<User> user = userRepository.findByUsername(userRegisterWebModel.getUsername());
        if (user.isPresent()) {
            throw new IllegalArgumentException(String.format
                    ("Username %s is already taken!", user.get().getUsername()));
        }
        if (userRepository.findAllByEmail(userRegisterWebModel.getEmail())) {
            throw new IllegalArgumentException(String.format
                    ("Email %s is already taken!", userRegisterWebModel.getEmail()));
        }
        if (!userRegisterWebModel.getPassword().equals(userRegisterWebModel.getConfirmPassword())){
            throw new IllegalArgumentException("Wrong password to confirm!");
        }
    }
}
