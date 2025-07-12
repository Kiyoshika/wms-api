package com.github.kiyoshika.wms_api.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerNewUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("User '%s' already exists.", userDto.getUsername()));

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.getRoles().add("USER");

        return userRepository.save(newUser);
    }
}
