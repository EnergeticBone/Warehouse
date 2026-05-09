package com.bone.warehouse.service;

import com.bone.warehouse.dto.request.UserCreateRequest;
import com.bone.warehouse.dto.request.UserDeleteRequest;
import com.bone.warehouse.dto.request.UserUpdateRequest;
import com.bone.warehouse.entity.User;
import com.bone.warehouse.exception.AppException;
import com.bone.warehouse.exception.ErrorCode;
import com.bone.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequest request){
        User user = new User();

        if (userRepository.existsByUsernameAndIsDeletedFalse(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new AppException(ErrorCode.WRONG_CFPASSWORD);
        }

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserUpdateRequest request){
        User user = getUserById(id);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public User deleteUser(String id, UserDeleteRequest request){
        User user = getUserById(id);

        user.setDeleted(true);

        return userRepository.save(user);
    }
}
