package com.ojeanahuel.inditex.application.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static final String GET_PRICES_URL = "/price?applicationDate={applicationDate}&productId={productId}&brandId={brandId}";

    @Test
    void shouldReturnPricesTest1() throws Exception {
        String applicationDate = "2020-06-14T10:00:00.000Z";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(get(GET_PRICES_URL, applicationDate, productId, brandId)).andExpect(status().isOk())
                .andExpect(content().json("{\"product_prices\":[{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":1,\"start_date\":\"2020-06-14T00:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":35.5}]}"))
                .andDo(print());
    }

    @Test
    void shouldReturnPricesTest2() throws Exception {
        String applicationDate = "2020-06-14T16:00:00.000Z";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(get(GET_PRICES_URL, applicationDate, productId, brandId)).andExpect(status().isOk())
                .andExpect(content().json("{\"product_prices\":[{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":1,\"start_date\":\"2020-06-14T00:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":35.5}," +
                        "{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":2,\"start_date\":\"2020-06-14T15:00Z\",\"end_date\":\"2020-06-14T18:30Z\",\"price\":25.45}]}"))
                .andDo(print());
    }

    @Test
    void shouldReturnPricesTest3() throws Exception {
        String applicationDate = "2020-06-14T21:00:00.000Z";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(get(GET_PRICES_URL, applicationDate, productId, brandId)).andExpect(status().isOk())
                .andExpect(content().json("{\"product_prices\":[{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":1,\"start_date\":\"2020-06-14T00:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":35.5}]}"))
                .andDo(print());
    }

    @Test
    void shouldReturnPricesTest4() throws Exception {
        String applicationDate = "2020-06-15T10:00:00.000Z";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(get(GET_PRICES_URL, applicationDate, productId, brandId)).andExpect(status().isOk())
                .andExpect(content().json("{\"product_prices\":[{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":1,\"start_date\":\"2020-06-14T00:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":35.5}," +
                        "{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":3,\"start_date\":\"2020-06-15T00:00Z\",\"end_date\":\"2020-06-15T11:00Z\",\"price\":30.5}]}"))
                .andDo(print());
    }

    @Test
    void shouldReturnPricesTest5() throws Exception {
        String applicationDate = "2020-06-16T21:00:00.000Z";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(get(GET_PRICES_URL, applicationDate, productId, brandId)).andExpect(status().isOk())
                .andExpect(content().json("{\"product_prices\":[{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":1,\"start_date\":\"2020-06-14T00:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":35.5}," +
                        "{\"product_id\":\"35455\",\"brand_id\":\"1\",\"price_list\":4,\"start_date\":\"2020-06-15T16:00Z\",\"end_date\":\"2020-12-31T23:59:59Z\",\"price\":38.95}]}"))
                .andDo(print());
    }
}
