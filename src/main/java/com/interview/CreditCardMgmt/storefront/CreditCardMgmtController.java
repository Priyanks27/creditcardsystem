package com.interview.CreditCardMgmt.storefront;

import com.interview.CreditCardMgmt.api.CreditCardController;
import com.interview.CreditCardMgmt.data.model.CreditCard;
import com.interview.CreditCardMgmt.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditCardMgmtController {

    private final CreditCardRepository creditCardRepository;

    @Autowired
    CreditCardController creditCardController;

    public CreditCardMgmtController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @GetMapping("/addCreditCards")
    public String addCreditCards(Model model) {
        model.addAttribute("creditCard", new CreditCard());
        return "AddCreditCard";
    }

    @PostMapping("/saveCreditCard")
    public String saveCreditCard(@ModelAttribute CreditCard creditCard)
    {
        creditCardController.addCreditCard(creditCard);
        return "redirect:creditcards";
    }

    @GetMapping("/creditcards")
    public String getCreditCards(Model model)
    {
        model.addAttribute("creditcards", creditCardRepository.findAll());
        return "CreditCardsMgmt";
    }
}
