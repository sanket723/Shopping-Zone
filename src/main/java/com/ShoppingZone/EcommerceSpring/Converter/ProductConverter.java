package com.ShoppingZone.EcommerceSpring.Converter;

import com.ShoppingZone.EcommerceSpring.Enum.ProductStatus;
import com.ShoppingZone.EcommerceSpring.Model.Product;
import com.ShoppingZone.EcommerceSpring.RequestDTO.ProductRequestDto;
import com.ShoppingZone.EcommerceSpring.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConverter {

    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        Product product = Product.builder()
                .name(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .category(productRequestDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();

        return product;
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){

        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                .productName(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();

        return productResponseDto;
    }
}
