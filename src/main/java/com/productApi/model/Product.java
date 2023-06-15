package com.productApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    private int id;
    private String pname;
    private double price;
    private int cid;
    private int sid;
}
