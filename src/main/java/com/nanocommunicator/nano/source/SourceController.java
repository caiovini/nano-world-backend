
package com.nanocommunicator.nano.source;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nanocommunicator.nano.models.BalanceResponse;
import com.nanocommunicator.nano.models.GeoLocationResponse;
import com.nanocommunicator.nano.models.PeersResponse;
import com.nanocommunicator.nano.models.TelemetryResponse;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


public interface SourceController {
	
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse( code = 500 , message = "Internal error" ) , @ApiResponse( code = 200 , message = "Returns ok" ) })
	@RequestMapping(value = "/getBalance/{address}" , 
			        method = RequestMethod.GET ,
			        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BalanceResponse> getBalance(@PathVariable("address") String address);
	
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse( code = 500 , message = "Internal error" ) , @ApiResponse( code = 200 , message = "Returns ok" ) })
	@RequestMapping(value = "/getPeers" , 
	        		method = RequestMethod.GET , 
	        		produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<PeersResponse> getPeers();
	
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse( code = 500 , message = "Internal error" ) , @ApiResponse( code = 200 , message = "Returns ok" ) })
	@RequestMapping(value = "/getGeoLocations" , 
	        		method = RequestMethod.GET , 
	        		produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<GeoLocationResponse> getLocations();
	
	@CrossOrigin
	@ApiResponses(value = { @ApiResponse( code = 500 , message = "Internal error" ) , @ApiResponse( code = 200 , message = "Returns ok" ) })
	@RequestMapping(value = "/getNodeTelemetry" , 
	        		method = RequestMethod.GET , 
	        		produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<TelemetryResponse> getNodeTelemetry();
    
}