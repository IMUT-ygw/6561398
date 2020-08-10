package com.imut.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description  自定义负载均衡算法
 * @date 22/7/2020 下午 8:16
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
