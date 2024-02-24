package com.example.exampleapiprojects.service;

import com.example.exampleapiprojects.repository.ForexRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StoreForexDataTest {
    @Mock
    private ForexRepository mockForexRepository;

    private StoreForexData storeForexDataUnderTest;

    @BeforeEach
    void setUp() {
        storeForexDataUnderTest = new StoreForexData();
        storeForexDataUnderTest.forexRepository = mockForexRepository;
    }

    @Test
    void testStoreForexDataRepositoryApiSuccess() {
        assertTrue(storeForexDataUnderTest.storeForexData() > 0);
    }

    @Test
    void testStoreForexDataRepositorySaveException() {

        when(mockForexRepository.insert(new ArrayList<>())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> {
            storeForexDataUnderTest.storeForexData();
        });


    }
}
