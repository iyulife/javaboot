package io.javaboot.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: 启动类测试
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@SpringBootTest(classes = JavaBootAdminApplicationTests.class)
@ComponentScan("io.javaboot")
@Slf4j
public class JavaBootAdminApplicationTests {

}