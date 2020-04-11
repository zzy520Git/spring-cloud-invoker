package notes.mvc.web.buyer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import notes.common.util.Result;
import notes.domain.entity.VenderEntity;
import notes.mvc.web.buyer.service.FeignTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description：
 *
 * @author zzy520git
 * @date 2020/1/17 14:41
 * @ see
 * @since
 */
@Slf4j
@RestController
@RequestMapping("/invoker/buyer")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired(required = false)
    private FeignTestClient feignTestClient;


    @RequestMapping("/index")
    public String sayHi() {
        String json = restTemplate.getForObject("http://eureka-provider/provider/index", String.class);
        return json;
    }

    @RequestMapping("/usefeign")
    public String useFeign() {
        log.error("feign测试");
        return feignTestClient.invokeProvider();
    }

    @RequestMapping("/result")
    public Result getResult() {
        //乱码问题
        String forObjectStr = restTemplate.getForObject("http://eureka-provider/provider/obj", String.class);
        Result<VenderEntity> forObject = JSON.parseObject(forObjectStr,
                new TypeReference<Result<VenderEntity>>() {
                });
        System.out.println(forObjectStr);
        System.out.println(forObject.getData().getClass());
        System.out.println(forObject.toString());
        return forObject;
    }
}
