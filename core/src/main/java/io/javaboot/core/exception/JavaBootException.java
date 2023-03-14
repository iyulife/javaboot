package io.javaboot.core.exception;

import io.javaboot.core.common.CommonResult;
import lombok.Data;

/**
 * Description: 统一异常-JavaBoot
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Data
public class JavaBootException extends RuntimeException {
    /**
     * 结果码
     */
    private String code;

    public JavaBootException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public JavaBootException(CommonResult result) {
        super(result.getResultModule() + result.getResultMsg());
        this.code = result.getResultCode();
    }
}
