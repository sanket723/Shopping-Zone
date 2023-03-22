package com.ShoppingZone.EcommerceSpring.Service;

import com.ShoppingZone.EcommerceSpring.Converter.ProductConverter;
import com.ShoppingZone.EcommerceSpring.Enum.Category;
import com.ShoppingZone.EcommerceSpring.Exception.SellerNotFoundException;
import com.ShoppingZone.EcommerceSpring.Model.Product;
import com.ShoppingZone.EcommerceSpring.Model.Seller;
import com.ShoppingZone.EcommerceSpring.Repository.ProductRepository;
import com.ShoppingZone.EcommerceSpring.Repository.SellerRepository;
import com.ShoppingZone.EcommerceSpring.RequestDTO.ProductRequestDto;
import com.ShoppingZone.EcommerceSpring.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws Exception {

        Seller seller;

        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid Seller id");
        }

        Product product = ProductConverter.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);

        sellerRepository.save(seller);

        //now return type is ProductResponseDto so making it
        ProductResponseDto productResponseDto = ProductConverter.ProductToProductResponseDto(product);

        return productResponseDto;

    }

    public List<ProductResponseDto> getAllProductsByCategory(Category category){

        List<Product> products = productRepository.findAllByCategory(category);

        List<ProductResponseDto> list = new ArrayList<>();

        for(Product product : products){
            ProductResponseDto productResponseDto = ProductConverter.ProductToProductResponseDto(product);
            list.add(productResponseDto);
        }

        return list;
    }
}
