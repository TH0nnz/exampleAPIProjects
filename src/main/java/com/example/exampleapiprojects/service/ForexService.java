package com.example.exampleapiprojects.service;


import com.example.exampleapiprojects.entity.Forex;
import com.example.exampleapiprojects.repository.ForexRepository;
import com.example.exampleapiprojects.util.Request.GetForexRequest;
import com.example.exampleapiprojects.util.Response.GetForexResponseFailed;
import com.example.exampleapiprojects.util.Response.GetForexResponseSuccess;
import com.example.exampleapiprojects.util.Response.ResponseCurrency;
import com.example.exampleapiprojects.util.Response.ResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForexService {

    @Autowired
    ForexRepository forexRepository;

    public Object getByDate(GetForexRequest request) {

        List<Forex> result;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fromDate = dateFormat.parse(request.getStartDate());
            Date toDate = dateFormat.parse(request.getEndDate());

            ArrayList<ResponseCurrency> currency = new ArrayList<ResponseCurrency>();
            result = forexRepository.findForexBetweenDate(fromDate, toDate);
            for (Forex forex : result) {
                currency.add(new ResponseCurrency(forex.getDate(), forex.getUsd_ntd()));
            }
            ResponseError error = new ResponseError("0000", "成功");
            return new GetForexResponseSuccess(error, currency);

        } catch (Exception e) {
            return new GetForexResponseFailed(new ResponseError("E001", "日期區間不符"));
        }
    }
}
