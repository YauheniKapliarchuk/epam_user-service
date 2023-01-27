package com.example.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser (UserDto userDto) {
        System.out.println("HHHH");
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setAmountOfPosts(0);

        return userRepository.save(user);
    }

    public Optional<User> getUserById (long id) {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isEmpty()) {
            throw new UserNotFoundException("User doesn’t exist with given id = " + id);
        }
        return currentUser;
    }

    public User updateUserById (long id, UserDto userDto) {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isEmpty()) {
            throw new UserNotFoundException("User doesn’t exist with given id = " + id);
        }

        return userRepository.save(currentUser.get());
    }

    public User updateAmountOfPosts (long id, UserDto userDto) {
        Optional<User> currentUser = userRepository.findById(id);

        currentUser.get().setAmountOfPosts(userDto.getAmountOfPosts());

        currentUser.ifPresent(user -> user.setUsername(userDto.getUsername()));

        return userRepository.save(currentUser.get());
    }

    public void deleteUserById (long id) {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isEmpty()) {
            throw new UserNotFoundException("User doesn’t exist with given id = " + id);
        }
        userRepository.delete(currentUser.get());
    }
}
