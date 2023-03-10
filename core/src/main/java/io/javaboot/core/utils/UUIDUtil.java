package io.javaboot.core.utils;

import cn.hutool.core.util.IdUtil;
import io.javaboot.core.exception.JavaBootException;
import org.apache.commons.lang3.StringUtils;

import static io.javaboot.core.enums.ExceptionEnum.JAVA_BOOT_TRACE_LOG_ID_IS_NULL;

/**
 * Description: UUID工具类
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public class UUIDUtil {

    private final static ThreadLocal<String> TRACE_LOG_ID = new ThreadLocal<>();

    /**
     * hutool 雪花算法实现的
     *
     * @return
     */
    public static String UUID() {
        return IdUtil.getSnowflakeNextIdStr();
    }

    /**
     * threadLocal 存储ID,用于多线程
     *
     * @return
     */
    public static String TID() {
        if (StringUtils.isBlank(TRACE_LOG_ID.get())) {
            TRACE_LOG_ID.set(UUID());
        }
        return TRACE_LOG_ID.get();
    }

    /**
     * threadLocal 销毁ID,用于多线程
     *
     * @return
     */
    public static String EID() {
        if (StringUtils.isBlank(TRACE_LOG_ID.get())) {
            throw new JavaBootException(JAVA_BOOT_TRACE_LOG_ID_IS_NULL);
        }
        try {
            return TRACE_LOG_ID.get();
        } finally {
            TRACE_LOG_ID.remove();
        }
    }
}
