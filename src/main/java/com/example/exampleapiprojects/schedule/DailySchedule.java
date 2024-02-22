package com.example.exampleapiprojects.schedule;

import com.example.exampleapiprojects.service.StoreForexData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailySchedule {
    @Autowired
    StoreForexData storeForexData;

    @Scheduled(cron = "0 0 18 * * ?")
    public void saveForexData() {
        storeForexData.storeForexData();
        System.out.println("saveForexData");
    }

}