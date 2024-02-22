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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsd_ntd() {
        return usd_ntd;
    }

    public void setUsd_ntd(String usd_ntd) {
        this.usd_ntd = usd_ntd;
    }

    public String getRmb_ntd() {
        return rmb_ntd;
    }

    public void setRmb_ntd(String rmb_ntd) {
        this.rmb_ntd = rmb_ntd;
    }

    public String getEur_usd() {
        return eur_usd;
    }

    public void setEur_usd(String eur_usd) {
        this.eur_usd = eur_usd;
    }

    public String getUsd_jpy() {
        return usd_jpy;
    }

    public void setUsd_jpy(String usd_jpy) {
        this.usd_jpy = usd_jpy;
    }

    public String getGbp_usd() {
        return gbp_usd;
    }

    public void setGbp_usd(String gbp_usd) {
        this.gbp_usd = gbp_usd;
    }

    public String getAud_usd() {
        return aud_usd;
    }

    public void setAud_usd(String aud_usd) {
        this.aud_usd = aud_usd;
    }

    public String getUsd_hkd() {
        return usd_hkd;
    }

    public void setUsd_hkd(String usd_hkd) {
        this.usd_hkd = usd_hkd;
    }

    public String getUsd_rmb() {
        return usd_rmb;
    }

    public void setUsd_rmb(String usd_rmb) {
        this.usd_rmb = usd_rmb;
    }

    public String getUsd_zar() {
        return usd_zar;
    }

    public void setUsd_zar(String usd_zar) {
        this.usd_zar = usd_zar;
    }

    public String getNzd_usd() {
        return nzd_usd;
    }

    public void setNzd_usd(String nzd_usd) {
        this.nzd_usd = nzd_usd;
    }

//    public Forex(Date date, String usd_ntd, String rmb_ntd, String eur_usd, String usd_jpy, String gbp_usd, String aud_usd, String usd_hkd, String usd_rmb, String usd_zar, String nzd_usd) {
//        this.date = date;
//        this.usd_ntd = usd_ntd;
//        this.rmb_ntd = rmb_ntd;
//        this.eur_usd = eur_usd;
//        this.usd_jpy = usd_jpy;
//        this.gbp_usd = gbp_usd;
//        this.aud_usd = aud_usd;
//        this.usd_hkd = usd_hkd;
//        this.usd_rmb = usd_rmb;
//        this.usd_zar = usd_zar;
//        this.nzd_usd = nzd_usd;
//    }


}
