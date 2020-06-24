package com.svc.exampreparation.services.Impl;

import com.svc.exampreparation.date.reposiroties.UserRepository;
import com.svc.exampreparation.date.User;
import com.svc.exampreparation.services.models.UserLoginServiceModel;
import com.svc.exampreparation.services.UserService;
import com.svc.exampreparation.services.models.UserRegisterServiceModel;
import com.svc.exampreparation.web.models.UserRegisterWebModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public void userLogin(UserLoginServiceModel loginServiceModel) {
        Optional<User> user = userRepository.findByUsername(loginServiceModel.getUsername());
        boolean pass = false;
        if (user.isPresent()) {
            String p1 = user.get().getPassword();
            String p2 = loginServiceModel.getPassword();
            pass = passwordEncoder.matches(loginServiceModel.getPassword(),user.get().getPassword());

        }

        if (!pass) {
            throw new IllegalArgumentException("Wrong username or password!");
        }
    }

    @Override
    public void register(UserRegisterWebModel userRegisterWebModel) {
        Optional<User> username = userRepository.findByUsername(userRegisterWebModel.getUsername());
        if (username.isPresent()) {
            throw new IllegalArgumentException(String.format
                    ("Username %s is already taken!", username.get().getUsername()));
        }
        Optional<User> email = userRepository.findByEmail(userRegisterWebModel.getEmail());
        if (email.isPresent()) {
            throw new IllegalArgumentException(String.format
                    ("Email %s is already taken!", userRegisterWebModel.getEmail()));
        }
        if (!userRegisterWebModel.getPassword().equals(userRegisterWebModel.getConfirmPassword())){
            throw new IllegalArgumentException("Wrong password to confirm!");
        }
        UserRegisterServiceModel user = mapper.map(userRegisterWebModel, UserRegisterServiceModel.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(mapper.map(user, User.class));
    }
}
