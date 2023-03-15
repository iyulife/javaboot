package io.javaboot.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Description: 启动类测试
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@SpringBootTest(classes = JavaBootAdminApplicationTests.class)
@ComponentScan("io.javaboot")
@Slf4j
class JavaBootAdminApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 进行邮件测试
     * 邮件的接收者和发送者要一样，否则会报错 “Caused by: com.sun.mail.smtp.SMTPSenderFailedException: 501 Mail from address must be same as authorization user.”
     */
    @Test
    public void testSend() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("3360739100@qq.com");
        message.setTo("3360739100@qq.com");
        message.setSubject("JavaBoot E-Mail Send Test");
        message.setText("收到这一封邮件，表明您正在使用JavaBoot，非常感谢！");
        this.javaMailSender.send(message); // 邮件发送
    }
}
