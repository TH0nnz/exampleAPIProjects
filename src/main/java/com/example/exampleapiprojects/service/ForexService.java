package com.example.exampleapiprojects.service;


import com.example.exampleapiprojects.util.Forex;
import com.example.exampleapiprojects.util.Request.GetForexRequest;
import com.example.exampleapiprojects.util.Response.GetForexResponseFailed;
import com.example.exampleapiprojects.util.Response.GetForexResponseSuccess;
import com.example.exampleapiprojects.util.Response.ResponseCurrency;
import com.example.exampleapiprojects.util.Response.ResponseError;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ForexService {

    public Object getByDate(GetForexRequest request) {

        List<Forex> result;
        try {
            //date轉換 設定條件
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fromDate = dateFormat.parse(request.getStartDate());
            Date toDate = dateFormat.parse(request.getEndDate());
            Criteria c1 = Criteria.where("Date").gte(fromDate);
            Criteria c2 = Criteria.where("Date").lte(toDate);
            Criteria c = new Criteria().andOperator(c1, c2);
            Query qry = Query.query(c);
            //取得連線
            MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "forex");
            result = mongoOps.find(qry, Forex.class, "info");
            ResponseError error = new ResponseError("0000", "成功");

            ArrayList<ResponseCurrency> currency = new ArrayList<ResponseCurrency>();
            for (Forex forex : result) {
                currency.add(new ResponseCurrency(forex.getDate(), forex.getUsd_ntd()));
            }
            return new GetForexResponseSuccess(error, currency);

        } catch (Exception e) {
            return new GetForexResponseFailed(new ResponseError("E001", "日期區間不符"));
        }
    }
}
