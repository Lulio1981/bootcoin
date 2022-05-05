package com.bootcamp.bootcoin.service;

import com.bootcamp.bootcoin.entity.TypeChange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeChangeService {

    public Flux<TypeChange> getAll();

    public Mono<TypeChange> getById(String id);

    public Mono<TypeChange> save(TypeChange typeChange);

    public Mono<TypeChange> update(TypeChange typeChange);

    public Mono<TypeChange> delete(String id);

    Mono<TypeChange> getByCurrencyOrigin(String currencyOrigin);

}
