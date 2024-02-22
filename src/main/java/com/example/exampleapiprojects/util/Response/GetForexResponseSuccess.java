package com.example.exampleapiprojects.util.Response;

import lombok.Data;

import java.util.List;
@Data

public class GetForexResponseSuccess {
    private ResponseError error;
    private List<ResponseCurrency> currency;

    public GetForexResponseSuccess(ResponseError error, List<ResponseCurrency> currency) {
        this.error = error;
        this.currency = currency;
    }


}

