package com.ojeanahuel.inditex.infrastracture.repository;

import com.ojeanahuel.inditex.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataH2PriceRepository extends JpaRepository<Price, UUID> {

    @Query(value = "select * from Prices a where a.start_date <= :applicationDateTime and a.end_date >= :applicationDateTime " +
            "and a.product_id = :productId and a.brand_id = :brandId", nativeQuery = true)
    List<Price> findAllWithParams(@Param("applicationDateTime") LocalDateTime applicationDateTime,
                                  @Param("productId") String productId,
                                  @Param("brandId") String brandId);
}
