//package com.example.exampleapiprojects.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLParameters;
//import javax.net.ssl.X509TrustManager;
//@RestController
//@RequestMapping("/GetForexData2")
//public class HttpClientExample {
//    @GetMapping("/test")
//    public void listAll1() throws Exception {
//        // 创建一个 SSL 上下文，用于忽略 SSL 验证
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, TrustAllCerts.getInstance(), new java.security.SecureRandom());
//
//        // 创建一个 HttpClient，设置 SSL 上下文和 SSL 参数
//        HttpClient httpClient = HttpClient.newBuilder()
//                .sslContext(sslContext)
//                .sslParameters(new SSLParameters())
//                .build();
//
//        // 创建一个 HTTP 请求
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates"))
//                .GET()
//                .build();
//
//        // 发送请求并获取响应
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//
//        // 输出响应内容
//        System.out.println(httpResponse.body());
//    }
//}
//
//// 自定义一个 TrustAllCerts 类，用于信任所有证书
//class TrustAllCerts implements X509TrustManager {
//    public static javax.net.ssl.X509TrustManager[] getInstance() {
//        return new javax.net.ssl.X509TrustManager[] { new TrustAllCerts() };
//    }
//
//    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//    }
//
//    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
//    }
//
//    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//        return new java.security.cert.X509Certificate[0];
//    }
//}
