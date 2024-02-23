package com.example.exampleapiprojects.util;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "info")
public class Forex {
    @Id
    private String id;
    @Field("Date")
    private Date date;
    @Field("USD/NTD")
    private String usd_ntd;
    @Field("RMB/NTD")
    private String rmb_ntd;
    @Field("EUR/USD")
    private String eur_usd;
    @Field("USD/JPY")
    private String usd_jpy;
    @Field("GBP/USD")
    private String gbp_usd;
    @Field("AUD/USD")
    private String aud_usd;
    @Field("USD/HKD")
    private String usd_hkd;
    @Field("USD/RMB")
    private String usd_rmb;
    @Field("USD/ZAR")
    private String usd_zar;
    @Field("NZD/USD")
    private String nzd_usd;


}
