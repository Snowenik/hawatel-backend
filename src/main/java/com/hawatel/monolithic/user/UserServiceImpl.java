package com.hawatel.monolithic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        return userRepository.findByLogin(userLoginDTO.getLogin());
    }
}
