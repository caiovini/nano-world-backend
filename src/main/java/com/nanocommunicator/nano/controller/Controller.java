package com.nanocommunicator.nano.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.nanocommunicator.nano.exceptions.NodeException;
import com.nanocommunicator.nano.mapper.BalanceMapper;
import com.nanocommunicator.nano.mapper.PeersMapper;
import com.nanocommunicator.nano.mapper.TelemetryMapper;
import com.nanocommunicator.nano.models.BalanceResponse;
import com.nanocommunicator.nano.models.GeoLocationResponse;
import com.nanocommunicator.nano.models.PeersResponse;
import com.nanocommunicator.nano.models.TelemetryResponse;
import com.nanocommunicator.nano.service.GetGeoLocation;
import com.nanocommunicator.nano.source.SourceController;

import lombok.extern.slf4j.Slf4j;
import uk.oczadly.karl.jnano.rpc.RpcQueryNode;
import uk.oczadly.karl.jnano.rpc.exception.RpcException;
import uk.oczadly.karl.jnano.rpc.request.node.RequestAccountBalance;
import uk.oczadly.karl.jnano.rpc.request.node.RequestPeers;
import uk.oczadly.karl.jnano.rpc.request.node.RequestTelemetry;
import uk.oczadly.karl.jnano.rpc.response.ResponseTelemetry;


@RestController
@Slf4j(topic = "error")
public class Controller implements SourceController{
	
	@Autowired
	private RpcQueryNode node;
	
	@Autowired
	private BalanceMapper balanceMapper;
	
	@Autowired
	private PeersMapper peersMapper;
	
	@Autowired
	private GetGeoLocation geoLocation;
	
	@Autowired
	private TelemetryMapper telemetryMapper;


	@Override
	public ResponseEntity<BalanceResponse> getBalance(String address) {
		
		RequestAccountBalance request = new RequestAccountBalance(address);

		try {
			
			BalanceResponse balance = balanceMapper.responseBalanceToBalanceResponse(node.processRequest(request));
			return ResponseEntity.ok(balance);
		} catch (IOException | RpcException e) {
			
			log.error(e.getMessage().concat(address));
		    throw new NodeException(e.getMessage());
		} 
		
	}

	@Override
	public ResponseEntity<PeersResponse> getPeers() {
		
		RequestPeers peers = new RequestPeers();
		
		try {
			
			PeersResponse peersResponse = peersMapper.responsePeersToPeersResponse(node.processRequest(peers));
			return ResponseEntity.ok(peersResponse);
		} catch (IOException | RpcException e) {
			
			log.error(e.getMessage());
		    throw new NodeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<GeoLocationResponse> getLocations() {
		
		return ResponseEntity.ok(geoLocation.getGeoLocation());
	}

	@Override
	public ResponseEntity<TelemetryResponse> getNodeTelemetry() {
		
		RequestTelemetry requestTelemetry = new RequestTelemetry();
		
		try {
			ResponseTelemetry responseTelemetry = node.processRequest(requestTelemetry);
			
			return ResponseEntity.ok(telemetryMapper.fromResponseTelemetryToTelemetryResponse(responseTelemetry));
		} catch (IOException | RpcException e) {
			
			log.error(e.getMessage());
		    throw new NodeException(e.getMessage());
		}
		
	}

}
