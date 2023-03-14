package io.javaboot.starter.log.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: Feign traceId拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public class LogFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(TRACE_ID, MDC.get(TRACE_ID));
    }
}
