package com.productApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class ProductDTO {
    @Id
    private int id;
    private String pname;
    private double price;
    private String sname;
    private String cname;
}
