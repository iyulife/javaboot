package io.javaboot.admin;

import io.javaboot.starter.cloud.annotation.EnableJavaBootDiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/21 16:43
 */
@SpringBootApplication
@Slf4j
@EnableScheduling
@EnableJavaBootDiscoveryClient
public class AdminApplication {
    public static void main(String[] args) {
        log.info("---JavaBoot Admin is starting ---");
        SpringApplication.run(AdminApplication.class, args);
        log.info("---JavaBoot Admin is running ---");
    }

    /**
     * 每 59 秒输出一次当前时间
     */
    @Scheduled(cron = "0/59 * * * * ?")
    public void run20s() {
        log.info("<=======Admin 定时任务:{}", LocalDateTime.now());
    }
}
