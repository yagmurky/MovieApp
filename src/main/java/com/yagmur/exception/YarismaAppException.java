package com.yagmur.exception;

import lombok.Getter;

@Getter
public class YarismaAppException extends RuntimeException{

    private final ErrorType errorType;
    public YarismaAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public YarismaAppException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
