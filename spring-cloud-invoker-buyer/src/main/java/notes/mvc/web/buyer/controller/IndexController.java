package notes.mvc.web.buyer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/index")
    public String sayHi() {
        log.warn("invoker/buyer.index");
        return "invoker/buyer";
    }
}
