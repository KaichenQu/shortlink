package com.kelsonq.shortlink.admin.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bloom filter configuration
 */
@Configuration
public class RBloomFilterConfiguration {

  /**
   * Bloom filter to prevent user registration from querying the database
   */
  @Bean
  public RBloomFilter<String> userRegisterCachePenetrationBloomFilter(RedissonClient redissonClient) {
    RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("UserRegisterCachePenetrationBloomFilter");
    cachePenetrationBloomFilter.tryInit(100000000L, 0.001);
    return cachePenetrationBloomFilter;
  }
}