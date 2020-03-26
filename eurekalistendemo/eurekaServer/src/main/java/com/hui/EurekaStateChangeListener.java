package com.hui;


import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    @EventListener//(condition = "#event.replication==false")
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        // 服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(serverId +"\t" + appName + " 服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
        // 服务注册事件
        String appName = eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName();
        System.out.println( appName + " 服务进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent eurekaInstanceRenewedEvent) {
        // 服务续约事件
        String appName = eurekaInstanceRenewedEvent.getAppName();
        String serverId = eurekaInstanceRenewedEvent.getServerId();
        System.out.println(serverId +"\t" + appName + " 服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent eurekaRegistryAvailableEvent) {
        System.out.println("注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent eurekaServerStartedEvent) {
        System.out.println("Eureka server 启动");
    }
}
