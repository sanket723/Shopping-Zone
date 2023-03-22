package com.ShoppingZone.EcommerceSpring.RequestDTO;

import com.ShoppingZone.EcommerceSpring.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {

    private int sellerId;

    private String productName;

    private int price;

    private int quantity;

    private Category category;
}
