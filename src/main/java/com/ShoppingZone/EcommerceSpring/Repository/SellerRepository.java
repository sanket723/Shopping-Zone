package com.ShoppingZone.EcommerceSpring.Repository;

import com.ShoppingZone.EcommerceSpring.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

}
