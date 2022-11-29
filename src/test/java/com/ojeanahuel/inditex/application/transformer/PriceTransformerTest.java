package com.ojeanahuel.inditex.application.transformer;

import com.ojeanahuel.inditex.domain.Price;
import com.ojeanahuel.inditex.openapi.dto.ProductPriceDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PriceTransformerTest {

    private PriceTransformer priceTransformer;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    void setUp() {
        priceTransformer = new PriceTransformerImpl();
    }

    @Test
    void shouldSuccessToProductPriceDTO(){
        Price price = new Price();
        price.setId(1);
        price.setPrice(new BigDecimal(35.5));
        price.setPriceList(1);
        price.setCurr("EUR");
        price.setPriority(1);
        price.setBrandId("1");
        price.setStartDate(LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER));
        price.setEndDate(LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER));

        List<ProductPriceDTO> productPriceDTOS = priceTransformer.toProductPricesDTO(Arrays.asList(price));

        ProductPriceDTO productPriceDTO = productPriceDTOS.stream().findFirst().get();

        assertNotNull(productPriceDTO);

        assertEquals(price.getPrice(), productPriceDTO.getPrice());
        assertEquals(price.getProductId(), productPriceDTO.getProductId());
        assertEquals(price.getPriceList(), productPriceDTO.getPriceList());
        assertEquals(price.getBrandId(), productPriceDTO.getBrandId());
        assertEquals(price.getStartDate().atOffset(ZoneOffset.UTC).toString(), productPriceDTO.getStartDate());
        assertEquals(price.getEndDate().atOffset(ZoneOffset.UTC).toString(), productPriceDTO.getEndDate());
    }
}
