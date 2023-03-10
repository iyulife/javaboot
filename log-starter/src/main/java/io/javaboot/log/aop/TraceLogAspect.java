package io.javaboot.log.aop;

import io.javaboot.core.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: 日志切面
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Aspect
@Component
@Slf4j
public class TraceLogAspect {
    /**
     * TODO 暂时去掉 ->|| @annotation(javax.annotation.PostConstruct)<- jdk17中改了包
     */
    @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void traceLogPointCut() {

    }

    @Around("traceLogPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MDC.put(TRACE_ID, UUIDUtil.UUID());
        return point.proceed();
    }
}
