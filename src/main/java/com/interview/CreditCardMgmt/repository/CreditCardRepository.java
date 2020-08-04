package com.interview.CreditCardMgmt.repository;

import com.interview.CreditCardMgmt.data.model.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    Optional<CreditCard> findByCreditCardNumber(Long creditCardNumber);

    @Query(value = "SELECT * FROM CREDIT_CARD where CREDIT_CARD_NUMBER LIKE %:keyword%", nativeQuery = true)
    Page<CreditCard> findByAllCreditCardNumberLike(@Param("keyword") String keyword, Pageable pageable);
}
