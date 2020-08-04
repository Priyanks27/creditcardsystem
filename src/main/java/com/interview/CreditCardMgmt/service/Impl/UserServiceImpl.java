package com.interview.CreditCardMgmt.service.Impl;

import com.interview.CreditCardMgmt.data.model.User;
import com.interview.CreditCardMgmt.repository.UserRepository;
import com.interview.CreditCardMgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) return optionalUser.get();
        else return new User();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User modifyUser(User user) {
        //TODO
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        //TODO
    }
}
