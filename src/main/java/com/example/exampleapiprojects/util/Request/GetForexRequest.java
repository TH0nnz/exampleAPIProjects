package com.example.exampleapiprojects.util.Request;

public class GetForexRequest {
    private String startDate;
    private String endDate;

    private String currency;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrency() {
        return currency;
    }

}
