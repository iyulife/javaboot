package io.javaboot.bootstrap;

import com.alibaba.fastjson.JSON;
import io.javaboot.bootstrap.controller.TestController;
import io.javaboot.bootstrap.controller.beans.dto.UserDTO;
import io.javaboot.bootstrap.controller.beans.vo.UserVO;
import io.javaboot.core.common.result.ResultModel;
import io.javaboot.core.utils.UUIDUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: 启动类测试
 *
 * @author iyuLife
 * @date 2023/3/10 11:11
 */
@SpringBootTest(classes = JavaBootBootstrapApplicationTests.class)
@ComponentScan("io.javaboot")
@Slf4j
class JavaBootBootstrapApplicationTests {

    @Resource
    private TestController testController;

    /**
     * 测试对象存储与返回
     * 测试log切面
     */
    @Test
    void setTestController() {
        UserDTO user = new UserDTO();
        user.setId(UUIDUtil.UUID());
        user.setAge("12");
        user.setName("埃隆马斯克");
        ResultModel<UserVO> resultModel = testController.index(user);
        if (resultModel != null && resultModel.getData() != null) {
            log.info("<===setTestController===> 返回结果：{}", JSON.toJSONString(resultModel.getData()));
        }
    }
}
