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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotBlank
    @Size(min=4, max=40, message="Length of the name should be between 4 to 40.")
    private String name;
    @NotBlank
    @Size(min=12, max=42, message="Length of the email should be between 12 to 42.")
    private String email;
    @NotBlank
    @Size(min=6, max=26, message="Length of the password should be between 6 to 26.")
    private String password;
    private String type;
    private  String status;
    private LocalDate createDate;
    private  Integer points;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Review> reviewList;

    @Valid
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "follower")
    private List<User> userList;
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Address billingAddress;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<UserOrder> userOrderList;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Cart cart;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private CreditCard creditCard;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller")
    private List<Product>productList;

    private Boolean hasAds;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", createDate=" + createDate +
                ", points=" + points +
                ", reviewList=" + reviewList +
                ", userList=" + userList +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", userOrderList=" + userOrderList +
                ", cart=" + cart +
                ", creditCard=" + creditCard +
                ", productList=" + productList +
                '}';
    }
}
