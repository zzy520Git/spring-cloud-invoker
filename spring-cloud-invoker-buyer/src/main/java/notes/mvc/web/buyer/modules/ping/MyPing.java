package notes.mvc.web.buyer.modules.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * Description：
 *
 * @author zzy-PC
 * @date 2020/4/11 18:12
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("这是一个自定义的IPing实现类" + server.getHost() + server.getHostPort());
        return true;
    }
}
