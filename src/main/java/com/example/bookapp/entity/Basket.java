package com.example.bookapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "basket")
@Data
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double sumOfPurchases;
    private double discount;
    private double sumOfPurchasesWithDiscount;

    private void discount() {
        if (sumOfPurchases <= 100) {
            this.discount = 0;
        }
        if (sumOfPurchases > 101) {
            this.discount = sumOfPurchases / 100 * 10;
        }
    }

    private void sumCorrection() {
        sumOfPurchasesWithDiscount = sumOfPurchases - discount;
    }
//@OneToOne
//@JoinColumn(name = "user_basket")
//    private User user;
}
