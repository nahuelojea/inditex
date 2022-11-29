package com.ojeanahuel.inditex.infrastracture.configuration;

import com.ojeanahuel.inditex.infrastracture.repository.SpringDataH2PriceRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = SpringDataH2PriceRepository.class)
public class H2DBConfiguration {
}
