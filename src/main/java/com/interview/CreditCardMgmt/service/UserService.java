package com.interview.CreditCardMgmt.service;

import com.interview.CreditCardMgmt.data.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User modifyUser(User user);

    void deleteUser(Long userId);

    User getUser(Long id);

    List<User> getAllUser();
}
