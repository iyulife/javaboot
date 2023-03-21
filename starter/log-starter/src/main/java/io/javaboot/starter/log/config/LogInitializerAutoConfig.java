package io.javaboot.starter.log.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.LocalDate;

/**
 * Description: 通过环境变量的形式注入 logging.file 自动维护 Spring Boot Admin Logger Viewer
 *
 * @author iyuLife
 * @date 2023/3/16 11:21
 */
@Slf4j
public class LogInitializerAutoConfig implements EnvironmentPostProcessor, Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String appName = environment.getProperty("spring.application.name");
        /**
         * 未获取到应用名称 TODO 不知道原因
         */
        if (StringUtils.isBlank(appName)) {
            return;
        }
        String logBase = environment.getProperty("LOGGING_PATH", "/var/log/javaBoot");
        LocalDate today = LocalDate.now();
        /**
         * 日志名 ${appName}-%d{yyyy-MM-dd}.%i.log
         */
        String appDateName = appName + "-" + today + ".0";
        String logFileName = String.format("%s/%s/%s.log", logBase, appName, appDateName);
        log.info("<===Spring Boot Admin Logger===> path: {}.log", logFileName);
        /**
         * spring boot admin 直接加载日志
         */
        System.setProperty("logging.file.name", logFileName);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
