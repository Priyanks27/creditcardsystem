package com.interview.CreditCardMgmt.service;

import com.interview.CreditCardMgmt.data.model.CreditCard;
import com.interview.CreditCardMgmt.exception.CreditCardNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CreditCardService {

    CreditCard createCreditCard(CreditCard creditCard);

    CreditCard findCreditCardById(Long creditCardId) throws CreditCardNotFoundException;

    CreditCard updateCreditCardById(CreditCard creditCardId) throws Exception;

    List<CreditCard> findAllCreditCardsByPagination(Long searchString, Integer limit, Integer offset);

    List<CreditCard> findAllCreditCards(Integer limit, Integer offset);
}
