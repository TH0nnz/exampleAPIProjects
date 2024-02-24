package com.example.exampleapiprojects.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ForexController.class)
class ForexControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private  final String postBody = "{ \"startDate\": \"2024/01/04\",\"endDate\": \"2024/01/05\",\"currency\": \"usd\"}";

    @Test
    void testGetByDate() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(post("/ForexApi/getForex").content(postBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertEquals(response.getStatus(),HttpStatus.OK.value());
    }
}
