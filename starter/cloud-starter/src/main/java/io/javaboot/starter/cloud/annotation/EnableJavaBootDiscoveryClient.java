package io.javaboot.starter.cloud.annotation;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClientImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/16 14:41
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableJavaBootFeignClients
@EnableDiscoveryClient
@Import({EnableDiscoveryClientImportSelector.class})
public @interface EnableJavaBootDiscoveryClient {
}
