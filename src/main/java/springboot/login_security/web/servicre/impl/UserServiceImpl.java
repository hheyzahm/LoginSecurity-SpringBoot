package springboot.login_security.web.servicre.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.login_security.utils.constants.RoleConstants;
import springboot.login_security.utils.exception.ResourceNotFoundException;
import springboot.login_security.web.domain.dto.UserDto;
import springboot.login_security.web.domain.model.Role;
import springboot.login_security.web.domain.model.User;
import springboot.login_security.web.reposiitory.RoleRepository;
import springboot.login_security.web.reposiitory.UserRepository;
import springboot.login_security.web.servicre.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:40 PM
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public User dtoToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto userToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }
    @Override
    public UserDto registerNewUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        // encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepository.findById(RoleConstants.NORMAL).get();
        //Role role=this.modelMapper.map(userDto.getRoles(), Role.class);

        user.getRoles().add(role);

        User newUser = this.userRepository.save(user);

        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto registerNewAdmin(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);

        // encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        // roles
        Role role = this.roleRepository.findById(RoleConstants.ADMIN).get();
        //Role role=this.modelMapper.map(userDto.getRoles(), Role.class);

        user.getRoles().add(role);

        User newUser = this.userRepository.save(user);

        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());


        User updatedUser = this.userRepository.save(user);
        return this.userToDto(updatedUser);
    }
    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        return this.userToDto(user);
    }
    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(this::userToDto).collect(Collectors.toList());

        return userDtos;
    }
    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        this.userRepository.delete(user);

    }
}