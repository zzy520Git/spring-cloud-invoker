package notes.mvc.web.vender.controller;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    /**
     * @see org.springframework.cloud.client.discovery.DiscoveryClient
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/index")
    public String sayHi() {
        log.warn("invoker/vender.index");
        return "invoker/vender";
    }

    @RequestMapping("/router")
    public String router() {
        List<ServiceInstance> serviceInstances = getServiceInstances();
        serviceInstances.forEach(t -> {
            EurekaServiceInstance service = (EurekaServiceInstance) t;
            InstanceInfo info = service.getInstanceInfo();
            //appName=EUREKA-INVOKER-VENDER，instanceId=192.168.0.110:eureka-invoker-vender:8782，status=UP
            log.error("appName={}，instanceId={}，status={}", info.getAppName(),
                    info.getInstanceId(), info.getStatus());
        });
        return "router";
    }

    /**
     * 查询可用服务
     *
     * @return
     */
    private List<ServiceInstance> getServiceInstances() {
        List<String> ids = discoveryClient.getServices();
        return ids.stream().map(t -> discoveryClient.getInstances(t))
                .flatMap(List::stream).collect(Collectors.toList());
    }
}
