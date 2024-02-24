package com.example.exampleapiprojects.controller;

import com.example.exampleapiprojects.service.ForexService;
import com.example.exampleapiprojects.util.Request.GetForexRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 查詢
 */
@RestController
@RequestMapping("/ForexApi")
public class ForexController {
    @Autowired
    ForexService forexService;

    @RequestMapping(value = "/getForex", method = RequestMethod.POST, produces="application/json")
    public Object getByDate(@RequestBody String str)  {
        Gson gson = new Gson();
        GetForexRequest request = gson.fromJson(str, GetForexRequest.class);
        return  forexService.getByDate(request);
    }
}