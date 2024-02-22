package com.example.exampleapiprojects.util.Response;

import lombok.Data;

@Data

public class GetForexResponseFailed {
    private ResponseError error;

    public GetForexResponseFailed(ResponseError error) {
        this.error = error;
    }


}

