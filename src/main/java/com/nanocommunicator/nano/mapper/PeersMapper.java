package com.nanocommunicator.nano.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.nanocommunicator.nano.models.PeersResponse;

import uk.oczadly.karl.jnano.rpc.response.ResponsePeers;

@Mapper(componentModel="spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PeersMapper {
	
	@Mapping(target = "peers", source = "peers")
	public PeersResponse responsePeersToPeersResponse(ResponsePeers responsePeers);

}
