package com.productApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String pname;
    private double price;
    private String sname;
    private String cname;
}
