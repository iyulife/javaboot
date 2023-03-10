package io.javaboot.core.common.result;

import static io.javaboot.core.enums.StatusEnum.F;
import static io.javaboot.core.enums.StatusEnum.S;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/10 17:28
 */
public final class ResultUtil {
    /**
     * 返回成功结果
     *
     * @param data 返回模型
     * @param <T>  泛类型
     * @return 结果
     */
    public static <T> ResultModel<T> success(T data) {
        ResultModelSupport<T> result = new ResultModelSupport<T>() {
            @Override
            public int getPageIndex() {
                return 0;
            }

            @Override
            public int getTotalCount() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }
        };
        result.setStatus(S.getCode());
        Message message = new Message(String.valueOf(S.getCode()), S.getMsg());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 自定义错误
     *
     * @param messageStr
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> fail(String code, String messageStr) {
        ResultModelSupport<T> result = new ResultModelSupport<>() {
            @Override
            public int getPageIndex() {
                return 0;
            }

            @Override
            public int getTotalCount() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }
        };
        result.setStatus(F.getCode());
        Message message = new Message(code, messageStr);
        result.setMessage(message);
        return result;
    }

}
