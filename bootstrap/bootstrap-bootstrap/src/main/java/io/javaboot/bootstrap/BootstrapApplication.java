package io.javaboot.bootstrap;

import io.javaboot.starter.cloud.annotation.EnableJavaBootDiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
@EnableScheduling
@EnableJavaBootDiscoveryClient
public class BootstrapApplication {
    public static void main(String[] args) {
        log.info("---JavaBoot Bootstrap is starting ---");
        SpringApplication.run(BootstrapApplication.class, args);
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
