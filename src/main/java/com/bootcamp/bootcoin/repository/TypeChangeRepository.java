package com.bootcamp.bootcoin.repository;

import com.bootcamp.bootcoin.entity.TypeChange;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TypeChangeRepository extends ReactiveCrudRepository<TypeChange, String> {

    Mono<TypeChange> findByCurrencyOrigin(String currencyOrigin);
}
