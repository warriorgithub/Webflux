package com.web.ecome.service;

import com.web.ecome.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {

    Mono<Product> save(Product product);
    Flux<Product> findAll();
}
