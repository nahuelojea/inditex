package com.ojeanahuel.inditex.infrastracture.configuration;

import com.ojeanahuel.inditex.domain.repository.PriceRepository;
import com.ojeanahuel.inditex.domain.service.PriceService;
import com.ojeanahuel.inditex.domain.service.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfiguration {

    @Bean
    PriceService priceService(final PriceRepository priceRepository) {
        return new PriceServiceImpl(priceRepository);
    }
}
