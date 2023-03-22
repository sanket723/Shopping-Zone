package com.ShoppingZone.EcommerceSpring.Converter;

import com.ShoppingZone.EcommerceSpring.Model.Seller;
import com.ShoppingZone.EcommerceSpring.RequestDTO.SellerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass    //uses for not creating object of this class, just call functions by name (as functions are static)

public class SellerConverter {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        // here we learn new method to create object of Dto without using new keyword (professional practice) using @Builder

        Seller seller = Seller.builder()
                        .name(sellerRequestDto.getName())
                        .email(sellerRequestDto.getEmail())
                        .mobNo(sellerRequestDto.getMobNo())
                        .panNo(sellerRequestDto.getPanNo())
                        .build();

        return seller;
    }
}
