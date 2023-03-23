package io.javaboot.bootstrap.controller;

import io.javaboot.bootstrap.controller.beans.dto.UserDTO;
import io.javaboot.bootstrap.controller.beans.vo.UserVO;
import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.common.result.ResultUtil;
import io.javaboot.starter.log.annotation.JavaBootTraceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 测试入参/返参/
 *
 * @author iyuLife
 * @date 2023/3/14 16:33
 */
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
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
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                log.info("<===线程打印===> {}",Thread.currentThread().getName());
            }).start();
        }
        return ResultUtil.success(vo);
    }
}
