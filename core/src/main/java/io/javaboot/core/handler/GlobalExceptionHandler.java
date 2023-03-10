package io.javaboot.core.handler;


import io.javaboot.core.common.result.ResultModelSupport;
import io.javaboot.core.exception.JavaBootException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: controller层全局拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 抛出异常时返回的信息
     *
     * @param javaBootException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(JavaBootException.class)
    public ResultModelSupport handle(JavaBootException javaBootException) {
        return ResultModelSupport.error(javaBootException.getCode(), javaBootException.getMessage());
    }
}
