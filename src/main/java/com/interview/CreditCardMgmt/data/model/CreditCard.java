package com.interview.CreditCardMgmt.data.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long creditCardId;

    @Column(name = "cardHolderName")
    private String cardHolderName;

    @Column(name="creditCardNumber")
    private Long creditCardNumber;

    @Column(name = "expiryDate")
    private String expiryDate; // Date format: "YY/MM"
}
