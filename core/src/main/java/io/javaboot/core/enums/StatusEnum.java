package io.javaboot.core.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/10 17:36
 */
@Getter
@RequiredArgsConstructor
public enum StatusEnum {
    S(1, "SUCCESS"),
    F(2, "FAIL"),
    U(3, "UNKNOWN"),
    ;
    private final int code;
    private final String msg;
}
