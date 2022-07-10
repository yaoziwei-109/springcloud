package com.yzw.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Component
public class GpFilterAbstractGatewayFilterFactory extends AbstractGatewayFilterFactory<GpFilterAbstractGatewayFilterFactory.Config>
{
    public GpFilterAbstractGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config)
    {
        return (exchange, chain) -> {
            System.out.println(config.getName());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        System.out.println("后置处理");
                    })
            );
        };
    }


    static class Config
    {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}