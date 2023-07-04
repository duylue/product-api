package com.productApi.repo;

import com.productApi.model.Customers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customers,Integer> {

}
