package io.javaboot.bootstrap.adapter.interfaced.controller;

import io.javaboot.bootstrap.interfaces.facade.beans.dto.UserDTO;
import io.javaboot.bootstrap.interfaces.facade.beans.vo.UserVO;
import io.javaboot.bootstrap.interfaces.facade.controller.BootstrapControl;
import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.common.result.ResultUtil;
import io.javaboot.starter.log.annotation.JavaBootTraceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class BootstrapController implements BootstrapControl {
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
            new Thread(() -> {
                log.info("<===线程打印===> {}", Thread.currentThread().getName());
            }).start();
        }
        return ResultUtil.success(vo);
    }
}
