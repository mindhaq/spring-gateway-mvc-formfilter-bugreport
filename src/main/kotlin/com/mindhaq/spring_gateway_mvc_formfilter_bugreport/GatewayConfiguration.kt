package com.mindhaq.spring_gateway_mvc_formfilter_bugreport

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http
import org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse

@Configuration
class GatewayConfiguration{
    @Bean
    fun getRoute(): RouterFunction<ServerResponse> =
        route("route_backend")
            .route(
                path("/get/**"),
                http("https://httpbin.org"),
            ).build()
}
