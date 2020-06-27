package com.svc.exam.services;

import com.svc.exam.services.models.UserLoginServiceModel;
import com.svc.exam.web.models.UserRegisterWebModel;

public interface UserService {
    void register(UserRegisterWebModel user);

    void userLogin(UserLoginServiceModel loginServiceModel);
}
