package io.javaboot;

import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.common.result.ResultUtil;
import io.javaboot.log.annotation.JavaBootTraceLog;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

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

    /**
     * 测试-------------------------------------------------------------------------------------------------------------
     */

    @Data
    public static final class User implements Serializable {

        private String id;
        private String name;
        private String age;
    }

    @RestController
    @RequestMapping(value = "/api/user")
    public class TestController {
        @RequestMapping(value = {"/index"})
        @ResponseBody
        @JavaBootTraceLog(value = "test")
        public ResultModel<User> index(@RequestBody User user) {
            return ResultUtil.success(user);
        }
    }

}
