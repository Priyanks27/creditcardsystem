package com.interview.CreditCardMgmt.service.Impl;

import com.interview.CreditCardMgmt.data.model.CreditCard;
import com.interview.CreditCardMgmt.exception.CreditCardNotFoundException;
import com.interview.CreditCardMgmt.repository.CreditCardRepository;
import com.interview.CreditCardMgmt.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard findCreditCardById(Long creditCardId) throws CreditCardNotFoundException {
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findByCreditCardNumber(creditCardId);
        if(optionalCreditCard.isPresent()) return optionalCreditCard.get();
        else throw new CreditCardNotFoundException("Credit card with id : " + creditCardId + " not found");
    }

    @Override
    public CreditCard updateCreditCardById(CreditCard creditCard) throws Exception {
        if (creditCard.getCreditCardId() == null || creditCard.getCreditCardId() == 0)
            throw new Exception("Credit card not found");

        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(creditCard.getCreditCardId());
        if(optionalCreditCard.isPresent()) {
            CreditCard creditCard1 = optionalCreditCard.get();
            creditCard1.setExpiryDate(creditCard.getExpiryDate());
            creditCardRepository.save(creditCard1);
            return creditCard1;
        }
        return creditCard;
    }

    @Override
    public List<CreditCard> findAllCreditCardsByPagination(Long searchString, Integer limit, Integer offset) {
        Pageable pageable = PageRequest.of(limit, offset);
        Page<CreditCard> creditCardPage =
                creditCardRepository.findByAllCreditCardNumberLike(String.valueOf(searchString), pageable);
        return creditCardPage.getContent();
    }

    @Override
    public List<CreditCard> findAllCreditCards(Integer limit, Integer offset) {
        Pageable pageable = PageRequest.of(limit, offset);
        Page<CreditCard> creditCardPage =
                creditCardRepository.findAll(pageable);
        return creditCardPage.getContent();
    }
}
