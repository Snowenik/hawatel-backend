package com.hawatel.monolithic.utilServices;

import com.hawatel.monolithic.user.User;
import com.hawatel.monolithic.user.UserRegisterDTO;
import com.hawatel.monolithic.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createNewAccount(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());
        user.setLogin(userRegisterDTO.getLogin());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setOperationList(new ArrayList<>());
        user.setProductList(new ArrayList<>());
        userRepository.save(user);
        return "Utworzono nowego uzytkownika";
    }
}














