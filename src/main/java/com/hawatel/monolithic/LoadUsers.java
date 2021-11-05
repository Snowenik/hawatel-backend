package com.hawatel.monolithic;

import com.hawatel.monolithic.user.User;
import com.hawatel.monolithic.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LoadUsers {

    @Bean
    public CommandLineRunner loadUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setFirstName("marek123");
            user.setLastName("marek123");
            user.setLogin("marek123");
            user.setPassword(passwordEncoder.encode("marek123"));
            user.setProductList(new ArrayList<>());
            user.setOperationList(new ArrayList<>());
            userRepository.save(user);

            User secondUser = new User();
            secondUser.setFirstName("hawatel");
            secondUser.setLastName("hawatel");
            secondUser.setLogin("hawatel123");
            secondUser.setPassword(passwordEncoder.encode("hawatel123"));
            secondUser.setProductList(new ArrayList<>());
            secondUser.setOperationList(new ArrayList<>());
            userRepository.save(secondUser);
        };
    }

}
