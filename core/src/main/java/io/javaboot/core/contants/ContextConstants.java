package io.javaboot.core.contants;

/**
 * Description: 核心器-上下文常量类
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public interface ContextConstants {
    /**
     * JWT中封装的 租户编码
     */
    String JWT_KEY_TENANT = "tenant";
    /**
     * JWT中封装的 子租户编码
     */
    String JWT_KEY_SUB_TENANT = "sub_tenant";
    /**
     * JWT中封装的 用户id
     */
    String JWT_KEY_USER_ID = "userid";
    /**
     * JWT中封装的 用户账号
     */
    String JWT_KEY_ACCOUNT = "account";
    /**
     * JWT中封装的 用户名称
     */
    String JWT_KEY_NAME = "name";
    /**
     * 灰度发布版本号
     */
    String HEADER_GRAY_VERSION = "gray_version";
    /**
     * 日志链路追踪id信息头
     */
    String HEADER_TRACE_ID = "x-trace-header";
    /**
     * 客户端的真实IP
     */
    String HEADER_REAL_IP = "X-Real-IP";
    /**
     * 每一级代理信息
     */
    String HEADER_FORWARDED_FOR = "x-forwarded-for";
    /**
     * 每一级代理信息
     */
    String TRACE_ID = "traceId";
}
