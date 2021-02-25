package com.web.ecome.handler;

import com.web.ecome.model.Product;
import com.web.ecome.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

    @Autowired
    IProductService productService;

    public Mono<ServerResponse> addProduct(ServerRequest serverRequest){
        final Mono<Product> product = serverRequest.bodyToMono(Product.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(product.flatMap(productService::save),Product.class));
    }

    public Mono<ServerResponse> getAllProduct(ServerRequest serverRequest){
        return ServerResponse.ok().body(productService.findAll(),Product.class);
    }


}
