package io.javaboot.log.handler;


import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.common.result.ResultUtil;
import io.javaboot.core.exception.JavaBootException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static io.javaboot.core.enums.StatusEnum.F;

/**
 * Description: controller层全局拦截器
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 抛出异常时返回的信息
     *
     * @param javaBootException
     * @return
     */
    @ResponseBody
    @ExceptionHandler(JavaBootException.class)
    public ResultModel<?> handle(JavaBootException javaBootException) {
        log.error("JavaBootException: code={},message={}", javaBootException.getCode(), javaBootException.getMessage());
        return ResultUtil.fail(javaBootException.getCode(), javaBootException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResultModel<?> otherHandle(Exception exception) {
        log.error("JavaBootException: code={},message={}", F.getCode(), exception.getMessage());
        return ResultUtil.fail(String.valueOf(F.getCode()), exception.getMessage());
    }
}
