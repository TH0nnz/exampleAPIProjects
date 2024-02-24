package com.example.exampleapiprojects.service;

import com.example.exampleapiprojects.entity.Forex;
import com.example.exampleapiprojects.repository.ForexRepository;
import com.example.exampleapiprojects.util.Request.GetForexRequest;
import com.example.exampleapiprojects.util.Response.GetForexResponseFailed;
import com.example.exampleapiprojects.util.Response.GetForexResponseSuccess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ForexServiceTest {

    @Mock
    private ForexRepository mockForexRepository;
    @Autowired
    private ForexService forexServiceUnderTest;

    @BeforeEach
    void setUp() {
        forexServiceUnderTest = new ForexService();
        forexServiceUnderTest.forexRepository = mockForexRepository;
    }

    @Test
    void testGetByDateSuccess() {

        final GetForexRequest request = new GetForexRequest();
        request.setStartDate("2024/01/04");
        request.setEndDate("2024/01/05");

        final Forex forex = new Forex();
        forex.setId("id");
        forex.setDate(new GregorianCalendar(2024, Calendar.JANUARY, 4).getTime());
        forex.setUsd_ntd("30");
        forex.setRmb_ntd("20");
        forex.setEur_usd("10");
        final List<Forex> forexes = List.of(forex);
        when(mockForexRepository.findForexBetweenDate(any(), any())).thenReturn(forexes);

        final GetForexResponseSuccess result = (GetForexResponseSuccess) forexServiceUnderTest.getByDate(request);

        assertEquals("30", result.getCurrency().get(0).getUsd());
        assertEquals("0000", result.getError().getCode());


    }

    @Test
    void testGetByDateFailed() {

        final GetForexRequest request = new GetForexRequest();
        request.setStartDate("20240104");
        request.setEndDate("2024/01/05");

        final Forex forex = new Forex();
        forex.setId("id");
        forex.setDate(new GregorianCalendar(2024, Calendar.JANUARY, 4).getTime());
        forex.setUsd_ntd("30");
        forex.setRmb_ntd("20");
        forex.setEur_usd("10");
        final List<Forex> forexes = List.of(forex);
        when(mockForexRepository.findForexBetweenDate(any(), any())).thenReturn(forexes);

        final GetForexResponseFailed result = (GetForexResponseFailed) forexServiceUnderTest.getByDate(request);

        assertEquals("E001", result.getError().getCode());

    }
}
