package edu.mum.cs.onlinemarketplace.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    @NotBlank
    @Size(min=5, max=25, message="{size.error}")
    private String name;
    @NotBlank
    @Size(min=11, max=31, message="{size.error}")
    private String email;
    @NotBlank
    @Size(min=6, max=20, message="{size.error}")
    private String password;
    private String type;
    private  String status;
    private LocalDate createDate;
    private  Integer points;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Review> reviewList;
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<User> userList;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    private List<UserOrder> userOrderList;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "buyer")
    private Cart cart;
    @Valid
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
