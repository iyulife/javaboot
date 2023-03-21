package io.javaboot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/15 15:08
 */
@EnableAdminServer
@SpringBootApplication
public class JavaBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaBootAdminApplication.class, args);
    }
}
