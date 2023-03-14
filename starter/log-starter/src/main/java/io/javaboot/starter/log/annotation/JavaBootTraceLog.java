package io.javaboot.starter.log.annotation;

import java.lang.annotation.*;

/**
 * Description: JavaBoot跟踪日志
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JavaBootTraceLog {
    String value() default "";
}
