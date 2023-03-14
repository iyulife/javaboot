package io.javaboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 启动类
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@SpringBootApplication
@Slf4j
public class JavaBootApplication {

    public static void main(String[] args) {
        log.info("---JavaBoot Bootstrap is starting ---");
        SpringApplication.run(JavaBootApplication.class, args);
        log.info("---JavaBoot Bootstrap is running ---");
    }

}
