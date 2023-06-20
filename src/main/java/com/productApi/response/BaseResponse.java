package com.productApi.response;

import com.productApi.exceptionHendler.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;


public class BaseResponse {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ResponseEntity<?> getResponseEntity(Object s){

        return ResponseEntity.status(200).body(getResponse(s));

    }
    private MyResponse getResponse(Object s){
        MyResponse response = new MyResponse();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(s);
        return response;

    }
}
