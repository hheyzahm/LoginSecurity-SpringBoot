package springboot.login_security.web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springboot.login_security.utils.constants.PUBLIC_URLS;
import springboot.login_security.utils.payload.ApiResponse;
import springboot.login_security.web.domain.dto.UserDto;
import springboot.login_security.web.servicre.UserService;

import java.util.List;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:58 PM
 */


@RestController
@RequestMapping(PUBLIC_URLS.REST_CONTROLLER_USER)//"/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST-create user
    @PostMapping(PUBLIC_URLS.REST_CONTROLLER_CREATE_USER)//"/createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // PUT- update user

    @PutMapping(PUBLIC_URLS.REST_CONTROLLER_UPDATE_USER+"{userId}")//"/updateUserById/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    //ADMIN
    // DELETE -delete user
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(PUBLIC_URLS.REST_CONTROLLER_DELETE_USER+"{userId}")//"/deleteUser/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
    }

    // GET - user get
    @GetMapping(PUBLIC_URLS.REST_CONTROLLER_GET_ALL_USER)//"/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // GET - user get
    @GetMapping(PUBLIC_URLS.REST_CONTROLLER_FETCH_SINGLE_USER+"{userId}")//"/fetchUserById/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
