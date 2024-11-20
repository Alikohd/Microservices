package com.example.apigateway.filter;

import com.example.apigateway.exception.UnauthorizedException;
import com.example.apigateway.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
    private final JwtUtil jwtUtil;

//    @Autowired
//    private RestTemplate template;

    public AuthFilter(JwtUtil jwtUtil) {
        super(Config.class);
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (RouteValidator.isSecured.test(exchange.getRequest())) {
                String authHeader = getAuthHeader(exchange);
                try {
                    jwtUtil.validateToken(authHeader);
                } catch (Exception e) {
                    System.out.println("Access token is invalid");
                    throw new UnauthorizedException("Unauthorized");
                }
            }
            return chain.filter(exchange);
        });
    }

    private static String getAuthHeader(ServerWebExchange exchange) {
        if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new UnauthorizedException("Authorization header is missing");
        }

        String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader = authHeader.substring(7);
        }
        return authHeader;
    }

    public static class Config {

    }
}