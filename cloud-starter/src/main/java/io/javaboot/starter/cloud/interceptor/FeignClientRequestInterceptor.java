package io.javaboot.starter.cloud.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Description: feign客户端请求拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
public class FeignClientRequestInterceptor implements RequestInterceptor {

    public FeignClientRequestInterceptor() {
        super();
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {

    }
}
