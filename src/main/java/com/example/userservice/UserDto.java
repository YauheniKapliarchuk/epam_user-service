package com.example.userservice;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDto {

    private String username;
    //remove or add
    private int amountOfPosts;
}
