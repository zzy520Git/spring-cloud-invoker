package notes.mvc.web.buyer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2020/1/17 11:27
 * @ see
 * @since
 */
@FeignClient("eureka-provider")
public interface FeignTestClient {

    /**
     * 映射调用服务提供者的对应rest api接口
     * @return
     */
    @RequestMapping("/provider/feigntest")
    String invokeProvider();

}
