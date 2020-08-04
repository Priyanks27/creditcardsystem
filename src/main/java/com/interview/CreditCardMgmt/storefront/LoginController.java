package com.interview.CreditCardMgmt.storefront;

import com.interview.CreditCardMgmt.data.model.CreditCard;
import com.interview.CreditCardMgmt.data.model.User;
import com.interview.CreditCardMgmt.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/validateUsernamePassword")
    public String validateUsernamePassword(@ModelAttribute User user)
    {
        Boolean validateUser = loginService.validateUsernameAndPassword(user.getUsername(), user.getPassword());
        if(validateUser) return "redirect:creditcards";
        return "redirect:home";
    }
}
