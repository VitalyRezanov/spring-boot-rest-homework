package com.netcracker.repository;

import com.netcracker.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value = "select shop_name from shop s where s.shop_area = :area", nativeQuery = true)
    List<String> retrieveName(@Param("area") String area);
}
