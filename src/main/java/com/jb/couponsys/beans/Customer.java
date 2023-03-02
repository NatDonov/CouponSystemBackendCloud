package com.jb.couponsys.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 50, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Singular
    private List<Coupon> coupons;

}
