package com.spring.springassignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    //declare fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name = "product_id",referencedColumnName = "id")
    )
    @JsonIgnoreProperties("customers")
    private List<Product> products = new ArrayList<>();

}
