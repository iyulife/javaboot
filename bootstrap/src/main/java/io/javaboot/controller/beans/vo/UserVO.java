package io.javaboot.controller.beans.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/14 16:34
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1905122041950251237L;

    private String id;
    private String name;
    private String age;
    private Long time;
}
