package com.ShoppingZone.EcommerceSpring.Model;

import com.ShoppingZone.EcommerceSpring.Enum.Category;
import com.ShoppingZone.EcommerceSpring.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    Item item;
}
