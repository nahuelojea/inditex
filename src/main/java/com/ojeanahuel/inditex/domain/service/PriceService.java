package com.ojeanahuel.inditex.domain.service;

import com.ojeanahuel.inditex.domain.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {

    /**
     *
     * @param applicationDate Date of application
     * @param productId Product identifier
     * @param brandId Brand identifier
     * @return List prices of products available within the specified parameters
     */
    List<Price> getPricesByParams (LocalDateTime applicationDate, String productId, String brandId);
}
