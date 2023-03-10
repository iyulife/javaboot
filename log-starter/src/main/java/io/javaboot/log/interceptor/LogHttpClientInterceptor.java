package io.javaboot.log.interceptor;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.slf4j.MDC;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: HTTP client traceId拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public class LogHttpClientInterceptor implements HttpRequestInterceptor {
    @Override
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        httpRequest.addHeader(TRACE_ID, MDC.get(TRACE_ID));
    }
}
