package io.javaboot.starter.log.aop;


import com.alibaba.fastjson.JSON;
import io.javaboot.core.utils.UUIDUtil;
import io.javaboot.starter.log.annotation.JavaBootTraceLog;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

import static io.javaboot.core.contants.ContextConstants.TRACE_ID;

/**
 * Description: JavaBoot跟踪日志拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Aspect
@Component
@Slf4j
public class JavaBootTraceLogAspect {
    /**
     * 签名，可以理解成这个切入点的一个名称
     */
    @Pointcut("@annotation(io.javaboot.starter.log.annotation.JavaBootTraceLog)")
    public void javaBootPointCut() {

    }

    @Before("javaBootPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logInfo(request, joinPoint);
    }

    /**
     * 获取url,请求方法，ip地址，类名以及方法名，参数
     */
    private void logInfo(HttpServletRequest request, JoinPoint joinPoint) {
        /**
         * 使用MDC,结合log使用
         */
        MDC.put(TRACE_ID, UUIDUtil.UUID());
        log.info("requestId={},url={},method={},ip={},class_method={},args={}",
                UUIDUtil.TID().getId(),
                request.getRequestURI(),
                request.getMethod(),
                request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                JSON.toJSONString(joinPoint.getArgs())
        );
    }

    @AfterReturning(pointcut = "javaBootPointCut()")
    public void printLog(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        JavaBootTraceLog javaBootTraceLog = method.getAnnotation(JavaBootTraceLog.class);
        if (javaBootTraceLog == null) {
            return;
        }
        log.info("responseId={},duration={}ns,result={},args={}",
                UUIDUtil.EID().getId(),
                System.nanoTime() - UUIDUtil.EID().getTime(),
                javaBootTraceLog.value(),
                JSON.toJSONString(joinPoint.getArgs())
        );
        UUIDUtil.TRACE_LOG_ID.remove();
        MDC.remove(TRACE_ID);
    }
}
