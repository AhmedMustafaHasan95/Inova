package com.inova.post.controller;

import com.inova.post.DTO.UserDTO;
import com.inova.post.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createSpace(@RequestBody @Valid UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok(userDTO);
    }
}
