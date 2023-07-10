package com.productApi.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.productApi.exception.BusinessException;
import com.productApi.model.Product;
import com.productApi.model.ProductDTO;
import com.productApi.repo.ProductDTORepo;
import com.productApi.repo.ProductRepo;
import com.productApi.response.BaseResponse;
import com.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductDTORepo dtoRepo;


    @Override
    public ResponseEntity<?> getAll(int page, int size) {
        try {

            Pageable pageable = PageRequest.of(page, size);
            return getResponseEntity(productRepo.findAll(pageable));
        } catch (Exception e) {
            throw new BusinessException(500, e.getMessage());
        }


    }

    @Override
    public ResponseEntity<?> getAll() {
        return getResponseEntity(productRepo.findAll());
    }

    @Override
    public ResponseEntity<?> save(Product product) {
        try {
            productRepo.save(product);
            return getResponseEntity("Tao Thanh Cong");
        } catch (Exception e) {
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        try {
            productRepo.deleteById(id);
            return getResponseEntity("Xoa Thanh Cong");
        } catch (Exception e) {
            throw new BusinessException(500, e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getEmSales() {
        return getResponseEntity(productRepo.getEmSales());
    }

    @Override
    public ResponseEntity<?> getSumSales(int pid) {
        return getResponseEntity(productRepo.getSumSales(pid));
    }

    @Override
    public ResponseEntity<?> getProductDTOList() {
        logger.info("----getProductDTOList----");
        try {
            List<Map<String, Objects>> maps = productRepo.getProductDTOList();
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<ProductDTO> dto = new ArrayList<>();
            if (!maps.isEmpty()){
                for (Map<String, Objects> m : maps) {
                    ProductDTO productDTO = mapper.convertValue(m,ProductDTO.class);
                    dto.add(productDTO);
                }
            }
            return getResponseEntity(dto);
        }catch (Exception e){
            throw new BusinessException(500,e.getCause().getMessage());
        }

    }

    @Override
    public ResponseEntity<?> getProductDTOByID(int id) {
        try {
            logger.info("----getProductDTOById---");
            Map<String,Objects> map = productRepo.getProductDTOByID(id);
            ObjectMapper mapper = new ObjectMapper();
            ProductDTO dto = mapper.convertValue(map,ProductDTO.class);
            return getResponseEntity(dto);

        }catch (Exception e){
            throw new BusinessException(500,e.getCause().getMessage());
        }

    }
}
