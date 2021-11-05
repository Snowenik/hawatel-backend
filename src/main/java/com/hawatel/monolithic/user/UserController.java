package com.hawatel.monolithic.user;

import com.hawatel.monolithic.authentication.AuthenticationRequest;
import com.hawatel.monolithic.authentication.AuthenticationResponse;
import com.hawatel.monolithic.userdetails.MyUserDetailsService;
import com.hawatel.monolithic.util.JwtUtil;
import com.hawatel.monolithic.utilServices.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RegistrationServiceImpl registrationService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Nieprawidłowy login lub hasło");
        }

        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getLogin());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/create")
    public @ResponseBody String createNewUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return registrationService.createNewAccount(userRegisterDTO);
    }

    @PostMapping("/login")
    public @ResponseBody User login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }


}









