package io.javaboot.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/15 18:01
 */
public class LogUtil {
    /***
     * 获取栈信息
     * @param exception 异常对象
     * @return 栈追踪的完整信息
     */
    public static String stackTrace(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
