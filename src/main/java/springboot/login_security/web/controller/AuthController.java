package springboot.login_security.web.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import springboot.login_security.utils.constants.PUBLIC_URLS;
import springboot.login_security.utils.exception.ApiException;
import springboot.login_security.utils.security.jwt.JwtAuthRequest;
import springboot.login_security.utils.security.jwt.JwtAuthResponse;
import springboot.login_security.utils.security.jwt.JwtTokenHelper;
import springboot.login_security.web.domain.dto.UserDto;
import springboot.login_security.web.domain.model.User;
import springboot.login_security.web.reposiitory.UserRepository;
import springboot.login_security.web.servicre.UserService;

import java.security.Principal;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 4:16 PM
 */


@RestController
@RequestMapping(PUBLIC_URLS.AUTH_URL)//"/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping(PUBLIC_URLS.AUTH_LOGIN)//"/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        System.out.println(token);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        response.setUser(this.mapper.map((User) userDetails, UserDto.class));
        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);

        try {

            this.authenticationManager.authenticate(authenticationToken);

        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details !!");
            throw new ApiException("Invalid username or password !!");
        }

    }

    // register new user api

    @PostMapping(PUBLIC_URLS.AUTH_REGISTER_USER)//"/registerUser")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
        UserDto registeredUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(PUBLIC_URLS.AUTH_REGISTER_ADMIN)//"/registerAdmin")
    public ResponseEntity<UserDto> registerAdmin(@Valid @RequestBody UserDto userDto) {
        UserDto registeredUser = this.userService.registerNewAdmin(userDto);
        return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
    }

    // get logged in user data
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(PUBLIC_URLS.AUTH_CURRENT_USER)//"/current-user/")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        User user = this.userRepo.findByEmail(principal.getName()).get();
        return new ResponseEntity<UserDto>(this.mapper.map(user, UserDto.class), HttpStatus.OK);
    }

}
