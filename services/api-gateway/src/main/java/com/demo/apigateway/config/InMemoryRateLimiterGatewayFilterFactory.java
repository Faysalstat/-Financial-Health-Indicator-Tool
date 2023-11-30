package com.demo.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryRateLimiterGatewayFilterFactory extends AbstractGatewayFilterFactory<InMemoryRateLimiterGatewayFilterFactory.Config> {

    private final Map<String, Integer> requestCounters = new ConcurrentHashMap<>();

    public InMemoryRateLimiterGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String key = String.valueOf(config.keyResolver.resolve(exchange));
            int currentCount = requestCounters.getOrDefault(key, 0);

            if (currentCount < config.limit) {
                requestCounters.put(key, currentCount + 1);
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(config.httpStatus));
                return exchange.getResponse().setComplete();
            }
        };
    }

    public static class Config {
        private KeyResolver keyResolver;
        private int limit;
        private int httpStatus;

        public KeyResolver getKeyResolver() {
            return keyResolver;
        }

        public void setKeyResolver(KeyResolver keyResolver) {
            this.keyResolver = keyResolver;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getHttpStatus() {
            return httpStatus;
        }

        public void setHttpStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }
    }
}
