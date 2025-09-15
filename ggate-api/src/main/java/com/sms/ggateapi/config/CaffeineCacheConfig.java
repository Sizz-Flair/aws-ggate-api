package com.sms.ggateapi.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * The type Caffeine cache config.
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {
    /**
     * Caffeine config caffeine.
     *
     * @return the caffeine
     */
    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                .initialCapacity(100) // 초기 캐시 용량
                .maximumSize(500)     // 최대 캐시 용량
                .recordStats()
                .expireAfterAccess(10, TimeUnit.MINUTES);
    }
}
