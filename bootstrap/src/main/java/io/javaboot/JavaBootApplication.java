package io.javaboot;

import io.javaboot.starter.cloud.annotation.EnableJavaBootDiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * Description: 启动类
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@SpringBootApplication
@Slf4j
@EnableScheduling
@EnableJavaBootDiscoveryClient
public class JavaBootApplication {

    public static void main(String[] args) {
        log.info("---JavaBoot Bootstrap is starting ---");
        SpringApplication.run(JavaBootApplication.class, args);
        log.info("---JavaBoot Bootstrap is running ---");
    }

    /**
     * 每 20 秒输出一次当前时间
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void run20s() {
        log.info("定时任务:{}", LocalDateTime.now());
    }

}
