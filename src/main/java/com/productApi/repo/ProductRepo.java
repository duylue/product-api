package com.productApi.repo;


import com.productApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value ="call test()" ,nativeQuery = true)
    List<Map<String, Objects>>getInfoSaleProduct();
}
