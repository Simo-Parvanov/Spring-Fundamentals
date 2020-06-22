package com.vsc.springescarshop.services.services;

import com.vsc.springescarshop.data.models.User;
import com.vsc.springescarshop.services.models.LoginServiceModel;
import com.vsc.springescarshop.services.models.UserRegisterServiceModel;
import com.vsc.springescarshop.web.models.RegisterUserModel;

public interface UserService {

    UserRegisterServiceModel createUser(UserRegisterServiceModel registerUserModel);

    LoginServiceModel loginUser(LoginServiceModel loginServiceModel);

    boolean equalPassword(String password, String confirmPassword);

    User getUserByUsername(String username);
}
