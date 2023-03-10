package io.javaboot.log.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description: 异步线程池配置
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Data
@Component
@ConfigurationProperties(prefix = "io.javaboot.async-thread-pool")
public class AsyncThreadPoolProperties {
    /**
     * 是否启动异步线程池，默认 false
     */
    private boolean enable = false;
    /**
     * 核心线程数,默认：Java虚拟机可用线程数
     */
    private Integer corePoolSize = 4;
    /**
     * 线程池最大线程数,默认：8
     */
    private Integer maxPoolSize = 8;
    /**
     * 线程队列最大线程数,默认：80000
     */
    private Integer queueCapacity = 8000;
    /**
     * 自定义线程名前缀，默认：Async-ThreadPool-
     */
    private String threadNamePrefix = "Async-ThreadPool-";
    /**
     * 线程池中线程最大空闲时间，默认：60，单位：秒
     */
    private Integer keepAliveSeconds = 60;
    /**
     * 核心线程是否允许超时，默认false
     */
    private boolean allowCoreThreadTimeOut = false;
    /**
     * IOC容器关闭时是否阻塞等待剩余的任务执行完成，默认:false（必须设置setAwaitTerminationSeconds）
     */
    private boolean waitForTasksToCompleteOnShutdown = false;
    /**
     * 阻塞IOC容器关闭的时间，默认：10秒（必须设置setWaitForTasksToCompleteOnShutdown）
     */
    private int awaitTerminationSeconds = 10;
}
