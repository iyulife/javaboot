package io.javaboot.core.common.result;

import lombok.Data;

/**
 * Description: 统一返回结果
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Data
public abstract class ResultModelSupport<T> implements ResultModel {

    private static final long serialVersionUID = 1905122041950251217L;

    /**
     * 返回的状态码
     */
    private Integer status;
    /**
     * 错误信息,成功的时候想携带一些也可以
     */
    private Message message;
    /**
     * 数据,只有正确的时候才携带
     */
    private T data;
}
