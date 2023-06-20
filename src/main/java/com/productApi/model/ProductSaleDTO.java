package com.productApi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class ProductSaleDTO {
    private double price;
    private long sumq;
    private long sump;
    private long id;
    private String pname;
    private long cid;
    private long sid;
}
