package io.javaboot.starter.cloud.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.JavaBootFeignClientsRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description: 重写feign注解，方便扩展
 *
 * @author iyuLife
 * @date 2023/3/16 14:28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
@Import(JavaBootFeignClientsRegistrar.class)
public @interface EnableJavaBootFeignClients {

}
