package io.javaboot.log.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;

import java.io.IOException;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: ok http traceId拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public class LogOkhttpInterceptor implements Interceptor {
    @Override
    public Response intercept(@NotNull okhttp3.Interceptor.Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader(TRACE_ID, MDC.get(TRACE_ID))
                .build();
        return chain.proceed(request);
    }
}
