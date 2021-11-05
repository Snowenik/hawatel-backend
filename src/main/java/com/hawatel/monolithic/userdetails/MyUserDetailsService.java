package com.hawatel.monolithic.userdetails;

import com.hawatel.monolithic.user.User;
import com.hawatel.monolithic.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(s);
        String userName = null;
        String password = null;
        if (user != null) {
            userName = user.getLogin();
            password = user.getPassword();
        }
        return new org.springframework.security.core.userdetails.User(userName, password, new ArrayList<>());
    }

}
