package io.javaboot.log.enums;

import io.javaboot.core.common.CommonResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description: 日志一次枚举
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@Getter
@RequiredArgsConstructor
public enum ExceptionEnum implements CommonResult {
    JAVA_BOOT_TRACE_LOG_ID_IS_NULL("1", "JavaBoot跟踪日志ID为空"),
    ;
    private final String code;
    private final String msg;

    @Override
    public String getResultCode() {
        return code;
    }

    @Override
    public String getResultMsg() {
        return msg;
    }

    @Override
    public String getResultModule() {
        return "log-stater";
    }
}
