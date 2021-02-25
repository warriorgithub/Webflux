package com.web.ecome.router;

import com.web.ecome.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ProductRouter {

    @Bean
    RouterFunction<?> routerFunction(ProductHandler productHandler){
        return RouterFunctions.route()
                .POST("/product/add", RequestPredicates.contentType(MediaType.APPLICATION_JSON),productHandler::addProduct)
                .GET("/product/all",productHandler::getAllProduct)
                .build();
    }


}
