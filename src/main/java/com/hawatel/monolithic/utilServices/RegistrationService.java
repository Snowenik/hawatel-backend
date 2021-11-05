package com.hawatel.monolithic.utilServices;

import com.hawatel.monolithic.user.UserRegisterDTO;

public interface RegistrationService {

    String createNewAccount(UserRegisterDTO userRegisterDTO);
}
