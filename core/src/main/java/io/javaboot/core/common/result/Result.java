package io.javaboot.core.common.result;

import java.io.Serializable;

/**
 * Description: 请求返回统一接口
 *
 * @author iyuLife
 * @date 2023/3/10 14:43
 */
public interface Result extends Serializable {
    Integer getStatus();

    Message getMessage();
}
