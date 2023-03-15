package io.javaboot.starter.log.config;

import io.javaboot.starter.log.properties.AsyncThreadPoolProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Description: 实现异步线程池自动化配置组件
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@EnableAsync
@Configuration
@EnableConfigurationProperties(AsyncThreadPoolProperties.class)
@ConditionalOnProperty(prefix = "io.javaboot.async-thread-pool", name = "enable", havingValue = "true")
public class LogAsyncConfig implements AsyncConfigurer {

}
