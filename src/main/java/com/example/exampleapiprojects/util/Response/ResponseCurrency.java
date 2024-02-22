package com.example.exampleapiprojects.util.Response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseCurrency {
    private Date data;
    private String usd;

    public ResponseCurrency(Date data, String usd) {
        this.data = data;
        this.usd = usd;
    }
}
