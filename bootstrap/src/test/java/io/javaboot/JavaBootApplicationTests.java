package io.javaboot;

import com.alibaba.fastjson.JSON;
import io.javaboot.controller.TestController;
import io.javaboot.controller.beans.dto.UserDTO;
import io.javaboot.controller.beans.vo.UserVO;
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
@SpringBootTest(classes = JavaBootApplicationTests.class)
@ComponentScan("io.javaboot")
@Slf4j
class JavaBootApplicationTests {

    @Resource
    private TestController testController;

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
