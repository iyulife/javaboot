package io.javaboot.core.contants;

/**
 * Description: 返回结果常量
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public interface ResultConstants {
    /**
     * 正确
     */
    String CODE_200 = "200";
    /**
     * 请求参数错误
     */
    String CODE_400 = "400";
    /**
     * 业务错误
     */
    String CODE_500 = "500";
    /**
     * 权限不足
     */
    String CODE_401 = "401";
    /**
     * 自定义(用户名不存在)
     */
    String CODE_601 = "601";
    /**
     * 自定义(密码不存在)
     */
    String CODE_602 = "602";
}
