package io.javaboot.controller.beans.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/14 16:34
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1905122041950251227L;

    private String id;
    private String name;
    private String age;
}
