package io.javaboot.core.common.result;

import lombok.Data;

import static io.javaboot.core.contants.ResultConstants.CODE_200;
import static io.javaboot.core.contants.ResultConstants.CODE_500;

/**
 * Description: 统一返回结果
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
@Data
public class ResultModelSupport<T> implements ResultModel {
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

    public ResultModelSupport(String code, String msg, T data) {
        Message myMsg = new Message(code, msg);
        this.message = myMsg;
        this.data = data;
    }

    public ResultModelSupport() {

    }

    /**
     * 返回一个200 状态码,无返回信息和数据
     */
    public static ResultModelSupport success() {
        return new ResultModelSupport(CODE_200, "", null);
    }

    /**
     * 返回一个200 状态码,并且携带参数,无返回信息
     */
    public static ResultModelSupport success(Object data) {
        return new ResultModelSupport(CODE_200, "", data);
    }

    /**
     * 返回一个固定带有500 状态码的错误信息
     */
    public static ResultModelSupport error() {
        return new ResultModelSupport(CODE_500, "业务异常", null);
    }

    /**
     * 返回一个自定义返回状态码以及错误信息
     */
    public static ResultModelSupport error(String code, String msg) {
        return new ResultModelSupport(code, msg, null);
    }

    @Override
    public Integer getStatus() {
        return null;
    }

    @Override
    public Message getMessage() {
        return null;
    }

    @Override
    public int getPageIndex() {
        return 0;
    }

    @Override
    public Integer getTotalCount() {
        return null;
    }

    @Override
    public int getPageSize() {
        return 0;
    }
}
