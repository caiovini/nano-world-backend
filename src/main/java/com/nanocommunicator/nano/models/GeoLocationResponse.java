package com.nanocommunicator.nano.models;

import java.util.ArrayList;
import java.util.List;

import com.maxmind.geoip2.model.CityResponse;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel
public class GeoLocationResponse{
	
	private List<CityResponse> cityResponse;
	
	public GeoLocationResponse() {
		
		this.cityResponse = new ArrayList<CityResponse>();
	}
	
	public void addCity(CityResponse cityResponse) {
		
		this.cityResponse.add(cityResponse);
	}

}
