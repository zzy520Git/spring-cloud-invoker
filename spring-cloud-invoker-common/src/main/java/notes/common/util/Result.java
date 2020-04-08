package notes.common.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Description:
 * Ajax返回值响应ResponseBody
 *
 * @author zzy520git
 * Date: 2018/7/29 9:06
 */
@Getter
@Setter
@ToString
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 业务code
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回实体
     */
    private T data;

    public static <T> Result<T> successResult(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> errorResult(String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        return result;
    }


}
