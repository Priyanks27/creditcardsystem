package com.interview.CreditCardMgmt.service.Impl;

import com.interview.CreditCardMgmt.data.model.User;
import com.interview.CreditCardMgmt.repository.UserRepository;
import com.interview.CreditCardMgmt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean validateUsernameAndPassword(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if(!optionalUser.isPresent()) return false; //TODO : custom message should be sent to the user

        User user = optionalUser.get();
        if(!user.getPassword().equals(password)) return false;

        return true;
    }
}
