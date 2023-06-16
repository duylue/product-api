package com.productApi.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MyResponse {
    private int status;
    private String message;
    private Object data;

}
