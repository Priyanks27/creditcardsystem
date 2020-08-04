package com.interview.CreditCardMgmt.data.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "nameToBeDisplayedOnCard", unique = true)
    private String nameToBeDisplayedOnCard;

    @Column(name="password")
    private String password;
}
