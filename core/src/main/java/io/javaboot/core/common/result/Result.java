package io.javaboot.core.common.result;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/10 14:43
 */
public interface Result {
    Integer getStatus();

    Message getMessage();
}
