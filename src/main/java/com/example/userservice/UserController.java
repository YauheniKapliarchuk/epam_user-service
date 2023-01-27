package com.example.userservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        return userService.updateUserById(id, userDto);
    }

    @PutMapping(value = "/count/{id}")
    public User updateAmountsOfPostsByUserId(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        return userService.updateAmountOfPosts(id, userDto);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return String.format("User with id = %s was deleted", id);
    }
}
