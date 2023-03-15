package io.javaboot.starter.log.filter;

import io.javaboot.core.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: dubbo traceId
 *
 * @author iyuLife
 * @date 2023/3/10 12:43
 */
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER})
public class LogDubboFilter implements Filter {

    /**
     * 获取dubbo上下文中的traceId
     * 获取上游来的traceId，并设置到dubbo的上下文，如果没有则生成一个
     * 设置traceId到日志到上下文
     *
     * @param invoker
     * @param invocation
     * @return
     * @throws RpcException
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = invocation.getAttachment(TRACE_ID);
        if (StringUtils.isNoneBlank(traceId)) {
            MDC.put(TRACE_ID, traceId);
            return invoker.invoke(invocation);
        }
        traceId = MDC.get(TRACE_ID);
        if (StringUtils.isNoneBlank(traceId)) {
            invocation.setAttachment(TRACE_ID, traceId);
            return invoker.invoke(invocation);
        }
        traceId = UUIDUtil.UUID();
        MDC.put(TRACE_ID, traceId);
        invocation.setAttachment(TRACE_ID, traceId);
        return invoker.invoke(invocation);
    }
}
