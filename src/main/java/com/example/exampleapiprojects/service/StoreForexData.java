package com.example.exampleapiprojects.service;

import com.example.exampleapiprojects.entity.Forex;
import com.example.exampleapiprojects.repository.ForexRepository;
import com.example.exampleapiprojects.util.TrustSslUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreForexData {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    ForexRepository forexRepository;

    public Integer storeForexData() {

        // 獲取需要的請求頭
        HttpHeaders httpHeaders = new HttpHeaders();
        // 設置請求實體
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        Integer storeSize;
        URI uri = null;
        try {
            uri = new URI("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates");

            // 忽略證書驗證
            TrustSslUtil.initDefaultSsl();
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);

            List<Forex> list = new ArrayList<>();
            Gson gson = new Gson();
            Forex[] forexBodyArray = gson.fromJson(responseEntity.getBody().replace("/", "_").toLowerCase(), Forex[].class);
            for (Forex forex : forexBodyArray) {
                list.add(forex);
            }
            storeSize=list.size();
            forexRepository.insert(list);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return storeSize;
    }

}
