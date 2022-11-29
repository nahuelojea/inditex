package com.ojeanahuel.inditex.domain.service;

import com.ojeanahuel.inditex.domain.Price;
import com.ojeanahuel.inditex.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    @Override
    public List<Price> getPricesByParams(LocalDateTime applicationDate, String productId, String brandId) {
        return priceRepository.getPricesByParams(applicationDate, productId, brandId);
    }
}
