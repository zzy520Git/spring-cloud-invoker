package notes.mvc.web.vender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zzy520git
 * @date 2020/01/01
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudInvokerVenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudInvokerVenderApplication.class, args);
	}

}
