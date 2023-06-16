package com.productApi.exceptionHendler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private int status;

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
    }

}
