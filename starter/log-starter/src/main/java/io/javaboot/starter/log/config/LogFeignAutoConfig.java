package io.javaboot.starter.log.config;

import feign.RequestInterceptor;
import io.javaboot.starter.log.interceptor.LogFeignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: feign 自动装配
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Configuration
public class LogFeignAutoConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new LogFeignInterceptor();
    }
}
