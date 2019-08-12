package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String validDate;

    private Long number;

    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "creditCard")
    private User user;
}
