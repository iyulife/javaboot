package io.javaboot.core.utils;

import cn.hutool.core.util.IdUtil;
import io.javaboot.core.beans.TraceLogBean;
import io.javaboot.core.exception.JavaBootException;

import java.util.HashMap;
import java.util.Map;

import static io.javaboot.core.enums.ExceptionEnum.JAVA_BOOT_TRACE_LOG_ID_IS_NULL;

/**
 * Description: UUID工具类
 *
 * @author iyuLife
 * @date 2023/3/10 10:41
 */
public class UUIDUtil {

    /**
     * 线程ID为key
     */
    public final static ThreadLocal<Map<Long, TraceLogBean>> TRACE_LOG_ID = new ThreadLocal<>();

    /**
     * hutool 雪花算法实现的
     *
     * @return
     */
    public static String UUID() {
        return IdUtil.getSnowflakeNextIdStr();
    }

    /**
     * threadLocal 存储ID,用于多线程,自己实现（没有使用MDC）
     *
     * @return
     */
    public static TraceLogBean TID() {
        if (TRACE_LOG_ID.get() == null || TRACE_LOG_ID.get().get(Thread.currentThread().getId()) == null) {
            TRACE_LOG_ID.set(getMap());
        }
        return TRACE_LOG_ID.get().get(Thread.currentThread().getId());
    }

    /**
     * 获取线程对应的log ,自己实现（没有使用MDC）
     *
     * @return
     */
    private static Map<Long, TraceLogBean> getMap() {
        Map<Long, TraceLogBean> map = new HashMap<>();
        TraceLogBean bean = new TraceLogBean();
        bean.setId(UUID());
        bean.setTime(System.nanoTime());
        map.put(Thread.currentThread().getId(), bean);
        return map;
    }

    /**
     * threadLocal 销毁ID,用于多线程 ,自己实现（没有使用MDC）
     *
     * @return
     */
    public static TraceLogBean EID() {
        if (TRACE_LOG_ID.get() == null || TRACE_LOG_ID.get().get(Thread.currentThread().getId()) == null) {
            throw new JavaBootException(JAVA_BOOT_TRACE_LOG_ID_IS_NULL);
        }
        return TRACE_LOG_ID.get().get(Thread.currentThread().getId());
    }
}
