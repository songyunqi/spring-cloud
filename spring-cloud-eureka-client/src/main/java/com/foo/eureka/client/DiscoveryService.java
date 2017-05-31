/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foo.eureka.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yang
 */
@Component
@RestController
public class DiscoveryService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public String doDiscoveryService() {
        StringBuilder buf = new StringBuilder();
        List<String> serviceIds = discoveryClient.getServices();
        if (!CollectionUtils.isEmpty(serviceIds)) {
            for (String s : serviceIds) {
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances = discoveryClient.getInstances(s);
                if (!CollectionUtils.isEmpty(serviceInstances)) {
                    for (ServiceInstance si : serviceInstances) {

                        buf.append("[")
                                .append(si.getServiceId())
                                .append(" host=")
                                .append(si.getHost())
                                .append(" port=")
                                .append(si.getPort())
                                .append(" uri=")
                                .append(si.getUri())
                                .append("]");
                    }
                } else {
                    buf.append("no service.");
                }
            }
        }

        return buf.toString();
    }

}
