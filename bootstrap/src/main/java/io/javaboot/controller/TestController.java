package io.javaboot.controller;

import io.javaboot.controller.beans.dto.UserDTO;
import io.javaboot.controller.beans.vo.UserVO;
import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.common.result.ResultUtil;
import io.javaboot.log.annotation.JavaBootTraceLog;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/14 16:33
 */
@RestController
@RequestMapping(value = "/api/user")
public class TestController {
    @RequestMapping(value = {"/index"})
    @ResponseBody
    @JavaBootTraceLog(value = "test")
    public ResultModel<UserVO> index(@RequestBody UserDTO user) {
        UserVO vo = new UserVO();
        vo.setAge(user.getAge());
        vo.setName(user.getName());
        vo.setId(user.getId());
        vo.setTime(System.nanoTime());
        return ResultUtil.success(vo);
    }
}
