package com.ShoppingZone.EcommerceSpring.Service;

import com.ShoppingZone.EcommerceSpring.Controller.SellerController;
import com.ShoppingZone.EcommerceSpring.Converter.SellerConverter;
import com.ShoppingZone.EcommerceSpring.RequestDTO.SellerRequestDto;
import com.ShoppingZone.EcommerceSpring.Model.Seller;
import com.ShoppingZone.EcommerceSpring.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public String addSeller(SellerRequestDto sellerRequestDto){

        Seller seller = SellerConverter.SellerRequestDtoToSeller(sellerRequestDto);

        sellerRepository.save(seller);

        return "Congrats!! Now you can sell on Shopping Zone";

    }

}
