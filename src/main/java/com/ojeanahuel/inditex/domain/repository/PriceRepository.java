package com.ojeanahuel.inditex.domain.repository;

import com.ojeanahuel.inditex.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> getPricesByParams (LocalDateTime applicationDate, String productId, String brandId);
}
