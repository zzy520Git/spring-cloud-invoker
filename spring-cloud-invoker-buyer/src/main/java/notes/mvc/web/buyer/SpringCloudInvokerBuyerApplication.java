package notes.mvc.web.buyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zzy520git
 * @date 2020/01/01
 */
//Zuul
@EnableZuulProxy
//Hystrix
@EnableCircuitBreaker
//openfeign
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudInvokerBuyerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudInvokerBuyerApplication.class, args);
	}

}
