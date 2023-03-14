package io.javaboot.starter.cloud.config;

import feign.Feign;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import io.javaboot.starter.cloud.feign.CustomFeignFormatterRegistrar;
import io.javaboot.starter.cloud.interceptor.FeignClientRequestInterceptor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description: openFeign 配置
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@ConditionalOnClass(Feign.class)
@AutoConfigureAfter(EnableFeignClients.class)
public class OpenFeignAutoConfiguration {

    @Bean
    public CustomFeignFormatterRegistrar dateFormatRegister() {
        return new CustomFeignFormatterRegistrar();
    }

    /**
     * feign支持MultipartFile上传文件
     */
    @Bean
    public Encoder feignFormEncoder() {
        List<HttpMessageConverter<?>> converters = new RestTemplate().getMessageConverters();
        ObjectFactory<HttpMessageConverters> factory = () -> new HttpMessageConverters(converters);
        return new SpringFormEncoder(new SpringEncoder(factory));
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestInterceptor requestInterceptor() {
        return new FeignClientRequestInterceptor();
    }
}
