package com.example.exampleapiprojects.controller;

import com.example.exampleapiprojects.util.Forex;
import com.example.exampleapiprojects.util.TrustSslUtil;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 批次
 **/
@RestController
@RequestMapping("/GetForexData")
public class GetForexData {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
    public List<Forex> listAll2() throws URISyntaxException {

        // 獲取需要的請求頭
        HttpHeaders httpHeaders = new HttpHeaders();
// 設置請求實體
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        URI uri = new URI("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates");

// 忽略證書驗證
        TrustSslUtil.initDefaultSsl();
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
//        System.out.println(responseEntity.getBody());

        Gson gson = new Gson();
        Forex[] forexBodyList = gson.fromJson(responseEntity.getBody().replace("/", "_").toLowerCase(), Forex[].class);



        return null;
    }


}
