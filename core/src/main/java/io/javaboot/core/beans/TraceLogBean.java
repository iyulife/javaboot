package io.javaboot.core.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/13 13:55
 */
@Data
public class TraceLogBean implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    /**
     * 日志ID
     */
    private String id;
    /**
     * 日志时间
     */
    private Long time;
}
