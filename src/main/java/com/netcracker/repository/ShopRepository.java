package com.netcracker.repository;

import com.netcracker.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "select shop_name from shop s where s.shop_area = :area", nativeQuery = true)
    List<String> retrieveName(@Param("area") String area);

    @Query(value = "select distinct shop.shop_name, shop.shop_area from orders,shop,customer where shop.id_shop=orders.id_shop " +
            "and orders.id_customer=customer.id_customer " +
            "and shop.shop_area not in (:area) " +
            "and customer.discount between :discount1 and :discount2",nativeQuery = true)
    List<String> retrieveShopByDiscountCustomer(@Param(value = "area") String area,
                                                      @Param("discount1") Integer discount1,
                                                      @Param(value = "discount2") Integer discount2);
}
