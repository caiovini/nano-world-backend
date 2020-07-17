package com.nanocommunicator.nano.serviceimpl;

import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.nanocommunicator.nano.exceptions.GeoException;
import com.nanocommunicator.nano.exceptions.NodeException;
import com.nanocommunicator.nano.mapper.PeersMapper;
import com.nanocommunicator.nano.models.GeoLocationResponse;
import com.nanocommunicator.nano.models.PeersResponse;
import com.nanocommunicator.nano.service.GetGeoLocation;

import lombok.extern.slf4j.Slf4j;
import uk.oczadly.karl.jnano.rpc.RpcQueryNode;
import uk.oczadly.karl.jnano.rpc.exception.RpcException;
import uk.oczadly.karl.jnano.rpc.request.node.RequestPeers;

@Component
@Slf4j(topic = "error")
public class GetGeoLocationImpl implements GetGeoLocation{
	
	@Autowired
	private RpcQueryNode node;
	
	@Autowired
	private DatabaseReader databaseReader;
	
	@Autowired
	private PeersMapper peersMapper;
	
	String IPADDRESS_PATTERN = 
	        "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";


	@Override
	public GeoLocationResponse getGeoLocation() {
		
		RequestPeers peers = new RequestPeers();
		Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
		
		try {
			
			PeersResponse peersResponse = peersMapper.responsePeersToPeersResponse(node.processRequest(peers));
			GeoLocationResponse geoLocationResponse = new GeoLocationResponse();
			
			peersResponse.getPeers().forEach((k , v) -> {
				
				try {
					
					Matcher matcher = pattern.matcher(k);
					
					if(matcher.find()) {
					
						InetAddress ipAddress = InetAddress.getByName(matcher.group());
						geoLocationResponse.addCity(databaseReader.city(ipAddress));
						
					}
					
				} catch (GeoIp2Exception e) {
					
					log.error(e.getMessage());
				
				} catch(IOException e) {
					
					log.error(e.getMessage());
					throw new GeoException(e.getMessage());
					
				}
				
			});
			
			
			return geoLocationResponse;
		} catch (IOException | RpcException e) {
			
			log.error(e.getMessage());
		    throw new NodeException(e.getMessage());
		}
	}

}
