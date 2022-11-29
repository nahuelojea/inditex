package com.ojeanahuel.inditex.application.transformer;

import com.ojeanahuel.inditex.domain.Price;
import com.ojeanahuel.inditex.openapi.dto.ProductPriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper
public interface PriceTransformer {

    List<ProductPriceDTO> toProductPricesDTO(List<Price> prices);

    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "toStringDate")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "toStringDate")
    ProductPriceDTO toProductPriceDTO(Price price);

    @Named("toStringDate")
    default String toStringDate(LocalDateTime localDateTime) {
        return localDateTime.atOffset(ZoneOffset.UTC).toString();
    }
}
