package io.javaboot.core.common.result;

/**
 * Description: 请求返回接口，增加数据和前端分页支持
 *
 * @author iyuLife
 * @date 2023/3/10 14:57
 */
public interface ResultModel<T> extends Result {
    /**
     * 返回结果模型
     *
     * @return
     */
    T getData();

    /**
     * 页面编码，从1开始
     *
     * @return
     */
    int getPageIndex();

    /**
     * 记录总数量
     *
     * @return
     */
    int getTotalCount();

    /**
     * 每页大小
     *
     * @return
     */
    int getPageSize();
}
