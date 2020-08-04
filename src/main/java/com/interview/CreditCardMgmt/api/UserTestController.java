package com.interview.CreditCardMgmt.api;

import com.interview.CreditCardMgmt.data.model.User;
import com.interview.CreditCardMgmt.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserTestController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable @NonNull Long id)
    {
        return userService.getUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }
}
