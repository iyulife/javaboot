package io.javaboot.core.common;

/**
 * Description: 统一异常枚举
 *
 * @author iyuLife
 * @date 2023/3/10 11:28
 */
public interface CommonResult {
    /**
     * 异常结果码
     *
     * @return
     */
    String getResultCode();

    /**
     * 异常结果
     *
     * @return
     */
    String getResultMsg();

    /**
     * 异常模块
     *
     * @return
     */
    String getResultModule();
}
