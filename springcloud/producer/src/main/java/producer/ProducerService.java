package producer;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.api;
import org.apache.dubbo.config.annotation.Service;

@NacosPropertySource(dataId = "producer", autoRefreshed = true)
@Service
public class ProducerService implements api {


    @NacosValue(value = "${info:hello yzw}", autoRefreshed = true)
    private String info;

    @Override
    public String getId(int id) {
        return  "我是生产者一号，id是" + id + info;
    }
}
