package notes.mvc.web.buyer.controller;

import lombok.extern.slf4j.Slf4j;
import notes.common.util.Result;
import notes.mvc.web.buyer.service.FeignTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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

        Result forObject = restTemplate.getForObject("http://eureka-provider/provider/obj", Result.class);
        try {
            Map data = (Map) forObject.getData();
            if (data != null) {
                log.warn("商家=【name={}】-【age={}】", data.get("name"), data.get("age"));
            }
        } catch (Exception e) {
            log.error("强制类型转换异常={}", forObject.toString(), e);
        }
        return forObject;
    }
}
