package com.productApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
public class Category {
    @Id
    private int cid;
    private String cname;
}
