//package com.productApi.repo;
//
//import com.productApi.model.ProductDTO;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//public interface ProductDTORepo extends PagingAndSortingRepository<ProductDTO,Integer> {
//    @Query(value = "select p.id\n" +
//            "     , p.pname\n" +
//            "     , p.price\n" +
//            "     , s.sname\n" +
//            "     , c.cname\n" +
//            "from product p,\n" +
//            "     status s,\n" +
//            "     category c\n" +
//            "where p.cid = c.cid\n" +
//            "  and p.sid = s.sid\n" +
//            "  and p.sid = s.sid\n", nativeQuery = true)
//    List<ProductDTO> getProductDTOList(     );
//}
