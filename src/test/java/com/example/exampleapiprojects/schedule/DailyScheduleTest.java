package com.example.exampleapiprojects.schedule;

import com.example.exampleapiprojects.service.StoreForexData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DailyScheduleTest {

    @Mock
    private StoreForexData mockStoreForexData;

    private DailySchedule dailyScheduleUnderTest;

    @BeforeEach
    void setUp() {
        dailyScheduleUnderTest = new DailySchedule();
        dailyScheduleUnderTest.storeForexData = mockStoreForexData;
    }

    @Test
    void testSaveForexData() {

        dailyScheduleUnderTest.saveForexData();

        verify(mockStoreForexData).storeForexData();
    }
}
