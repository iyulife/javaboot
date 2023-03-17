package io.javaboot.starter.thirdparty.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/16 20:06
 */
@Configuration
public class MailAutoConfig {

    private final Environment environment;

    public MailAutoConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(environment.getProperty("spring.mail.host"));
        javaMailSender.setUsername(environment.getProperty("spring.mail.username"));
        javaMailSender.setPassword(environment.getProperty("spring.mail.password"));
        return javaMailSender;
    }
}
