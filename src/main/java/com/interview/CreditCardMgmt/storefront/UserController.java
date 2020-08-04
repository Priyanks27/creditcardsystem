package com.interview.CreditCardMgmt.storefront;

import com.interview.CreditCardMgmt.data.model.User;
import com.interview.CreditCardMgmt.repository.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "SignUp";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Validated User user)
    {
        userRepository.save(user);
        return "redirect:creditcards";
    }
}
