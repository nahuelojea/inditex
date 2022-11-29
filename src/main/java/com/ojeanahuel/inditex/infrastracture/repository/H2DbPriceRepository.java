package com.ojeanahuel.inditex.infrastracture.repository;

import com.ojeanahuel.inditex.domain.Price;
import com.ojeanahuel.inditex.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
@Primary
public class H2DbPriceRepository implements PriceRepository {

    private final SpringDataH2PriceRepository priceRepository;

    @Override
    public List<Price> getPricesByParams(LocalDateTime applicationDate, String productId, String brandId) {
        return priceRepository.findAllWithParams(applicationDate, productId, brandId);
    }
}
