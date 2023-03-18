package com.gateway.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.gateway.project.Configuration.RibbonEurekaClientConfig;

@EnableZuulProxy
@EnableDiscoveryClient
@RibbonClients(defaultConfiguration = RibbonEurekaClientConfig.class)
@SpringBootApplication
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

}
