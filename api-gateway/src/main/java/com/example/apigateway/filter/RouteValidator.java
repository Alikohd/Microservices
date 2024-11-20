package com.example.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouteValidator {

    public static final List<String> publicApiEndpoints = List.of(
            "/auth/register",
            "/auth/token"
    );

    public static Predicate<ServerHttpRequest> isSecured =
            request -> publicApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}