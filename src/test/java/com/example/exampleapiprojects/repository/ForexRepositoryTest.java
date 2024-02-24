package com.example.exampleapiprojects.repository;

import com.example.exampleapiprojects.entity.Forex;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
class ForexRepositoryTest {
    final private String data = "[{\"Date\":\"20240102\",\"USD/NTD\":\"30.866\",\"RMB/NTD\":\"4.325685\",\"EUR/USD\":\"1.1031\",\"USD/JPY\":\"141.345\",\"GBP/USD\":\"1.2757\",\"AUD/USD\":\"0.6832\",\"USD/HKD\":\"7.81295\",\"USD/RMB\":\"7.1355\",\"USD/ZAR\":\"18.3847\",\"NZD/USD\":\"0.6312\"},\n" +
            "{\"Date\":\"20240103\",\"USD/NTD\":\"31.01\",\"RMB/NTD\":\"4.338299\",\"EUR/USD\":\"1.0963\",\"USD/JPY\":\"142.435\",\"GBP/USD\":\"1.26495\",\"AUD/USD\":\"0.67565\",\"USD/HKD\":\"7.81025\",\"USD/RMB\":\"7.14795\",\"USD/ZAR\":\"18.54865\",\"NZD/USD\":\"0.6264\"},\n" +
            "{\"Date\":\"20240104\",\"USD/NTD\":\"31.016\",\"RMB/NTD\":\"4.334207\",\"EUR/USD\":\"1.0947\",\"USD/JPY\":\"143.465\",\"GBP/USD\":\"1.26855\",\"AUD/USD\":\"0.6751\",\"USD/HKD\":\"7.8067\",\"USD/RMB\":\"7.1561\",\"USD/ZAR\":\"18.643\",\"NZD/USD\":\"0.62735\"},\n" +
            "{\"Date\":\"20240105\",\"USD/NTD\":\"31.025\",\"RMB/NTD\":\"4.328515\",\"EUR/USD\":\"1.0924\",\"USD/JPY\":\"144.975\",\"GBP/USD\":\"1.26865\",\"AUD/USD\":\"0.67\",\"USD/HKD\":\"7.8094\",\"USD/RMB\":\"7.1676\",\"USD/ZAR\":\"18.7534\",\"NZD/USD\":\"0.62315\"},\n" +
            "{\"Date\":\"20240108\",\"USD/NTD\":\"31.001\",\"RMB/NTD\":\"4.322686\",\"EUR/USD\":\"1.0933\",\"USD/JPY\":\"144.555\",\"GBP/USD\":\"1.2698\",\"AUD/USD\":\"0.66885\",\"USD/HKD\":\"7.8091\",\"USD/RMB\":\"7.1717\",\"USD/ZAR\":\"18.7882\",\"NZD/USD\":\"0.6223\"}]";
    List<Forex> list = new ArrayList<>();

    @BeforeEach
    public void setupTestData() {
        Gson gson = new Gson();
        Forex[] forexBodyArray = gson.fromJson(data.replace("/", "_").toLowerCase(), Forex[].class);
        for (Forex forex : forexBodyArray) {
            list.add(forex);
        }
    }

    @Autowired
    ForexRepository forexRepository;

    @Test
    void saveForex() {
        Gson gson = new Gson();
        Forex[] forexArray = gson.fromJson(data, Forex[].class);
        List<Forex> list = Arrays.asList(forexArray);
        assertEquals(list,forexRepository.saveAll(list));

    }
    @Test
    void findForexBetweenDate() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date fromDate = dateFormat.parse("2024/01/04");
        Date toDate = dateFormat.parse("2024/01/05");
        assertThat(forexRepository.findForexBetweenDate(fromDate, toDate)).isNotEmpty();

    }

}