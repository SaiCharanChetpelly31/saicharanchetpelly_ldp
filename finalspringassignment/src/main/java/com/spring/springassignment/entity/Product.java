package com.spring.springassignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    //declare fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
        name = "order_item",
        joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
        inverseJoinColumns =@JoinColumn(name = "customer_id",referencedColumnName = "id")
    )
    @JsonIgnoreProperties("products")
    private List<Customer> customers = new ArrayList<>();
}
