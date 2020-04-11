package notes.mvc.web.buyer.modules.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * Description：
 * RoundRobinRule 轮询
 * WeightedResponseTimeRule 权重（根据响应时间）
 * RandomRule 随机
 *
 * @author zzy-PC
 * @date 2020/4/11 18:07
 */
public class MyLoadBalancerRule implements IRule {
    @Override
    public Server choose(Object key) {
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return null;
    }
}
