package com.ojeanahuel.inditex.application.rest;


import com.ojeanahuel.inditex.application.transformer.PriceTransformer;
import com.ojeanahuel.inditex.domain.Price;
import com.ojeanahuel.inditex.domain.service.PriceService;
import com.ojeanahuel.inditex.openapi.api.PriceApi;
import com.ojeanahuel.inditex.openapi.dto.GetPrice200ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PriceController implements PriceApi {

    private final PriceService priceService;
    private final PriceTransformer priceTransformer;

    @Override
    public ResponseEntity<GetPrice200ResponseDTO> getPrice(OffsetDateTime applicationDate, String productId, String brandId) {
        List<Price> prices = priceService.getPricesByParams(applicationDate.toLocalDateTime(), productId, brandId);
        return ResponseEntity.ok(new GetPrice200ResponseDTO().productPrices(priceTransformer.toProductPricesDTO(prices)));
    }
}
