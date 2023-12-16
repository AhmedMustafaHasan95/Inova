package com.inova.post.service.users;

import com.inova.post.DTO.UserDTO;
import com.inova.post.entity.User;
import com.inova.post.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }
}
