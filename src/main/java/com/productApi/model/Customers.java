package com.productApi.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Customers {
    @Id
    private int cusid;
    private String cusname;
    private Date birthday;
    private String phone;
    private String aid;

}
