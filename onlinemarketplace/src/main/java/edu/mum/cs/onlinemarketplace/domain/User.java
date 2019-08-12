package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String name;
    private String email;
    private String password;
    private String type;
    private  String status;
    private LocalDate createDate;
    private  Integer points;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Review> reviewList;
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<User> userList;
    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<UserOrder> userOrderList;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},mappedBy = "buyer")
    private Cart cart;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private CreditCard creditCard;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    private List<Product>productList;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}
