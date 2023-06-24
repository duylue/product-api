package com.productApi.repo;


import com.productApi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    @Query(value = "select e.emid,e.emname,e.birthday,e.phone, o.oid from\n" +
            "                    employees e join orders o\n" +
            "on e.emid = o.emid", nativeQuery = true)
    List<Map<String, Objects>> getEmSales();

    @Query(value = "select od.pid, p.pname, price, sum(od.quantity) sumq, sum(od.quantity * p.price) sum\n" +
            "from orderdetails od\n" +
            "         join product p\n" +
            "              on od.pid = p.id\n" +
            "where od.pid = :pid \n" +
            "group by  od.pid\n" +
            "order by pid;", nativeQuery = true)
    Map<String, Objects> getSumSales(@Param("pid") int pid);

    @Query(value = "select p.id\n" +
            "     , p.pname\n" +
            "     , p.price\n" +
            "     , s.sname\n" +
            "     , c.cname\n" +
            "from product p,\n" +
            "     status s,\n" +
            "     category c\n" +
            "where p.cid = c.cid\n" +
            "  and p.sid = s.sid\n" +
            "limit 10", nativeQuery = true)
    List<Map<String, Objects>> getProductDTOList();

    List<Product> findAllBySid(int sid, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    List<Product>  findAll(Sort sort);
}
