package com.svc.exampreparation.services;

import com.svc.exampreparation.services.models.UserLoginServiceModel;
import com.svc.exampreparation.web.models.UserRegisterWebModel;

public interface UserService {
    void userLogin(UserLoginServiceModel loginServiceModel);

    void register(UserRegisterWebModel user);
}
