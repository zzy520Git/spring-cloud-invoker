package notes.mvc.web.vender.controller;

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
@RequestMapping("/invoker/vender")
public class IndexController {
    @RequestMapping("/index")
    public String sayHi() {
        log.warn("invoker/vender.index");
        return "invoker/vender";
    }
}
