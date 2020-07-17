package com.nanocommunicator.nano.config;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.oczadly.karl.jnano.rpc.RpcQueryNode;

@Configuration
public class NodeConfig {
	
	@Value("${nano-node.host}")
	private String host;
	
	@Value("${nano-node.port}")
	private Integer port;
	
	
	@Bean
	public RpcQueryNode getNode() throws MalformedURLException {
		
		return new RpcQueryNode(host , port);
	}

}
