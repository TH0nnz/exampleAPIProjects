package com.example.exampleapiprojects.util.Response;

import lombok.Data;

@Data
public class  ResponseError {
    private String  code;
    private String  message;

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
