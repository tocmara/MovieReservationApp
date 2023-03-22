package com.example.project.service;

import com.example.project.dto.User;
import com.example.project.model.UserModel;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository;}

    public User createUser(User user)
    {
        UserModel userModel = convertToUserModel(user);
        UserModel savedUserModel = userRepository.save(userModel);
        User createdUser = convertToUser(savedUserModel);

        return createdUser;
    }

    public List<User> findAll()
    {
        return userRepository.findAll()
                .stream()
                .map(this::convertToUser)
                .toList();
    }

    public void delete(int userId){ userRepository.deleteById(userId);}






    private UserModel convertToUserModel(User user)
    {
        UserModel userModel = new UserModel();

        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());
        userModel.setDateOfBirth(user.getDate());

        return userModel;

    }

    private User convertToUser(UserModel usermodel)
    {
        User user = new User();
        user.setName(usermodel.getName());
        user.setDate(usermodel.getDateOfBirth());
        user.setEmail(usermodel.getEmail());

        return user;
    }

}


