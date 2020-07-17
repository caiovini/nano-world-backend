package com.nanocommunicator.nano.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.nanocommunicator.nano.models.BalanceResponse;

import uk.oczadly.karl.jnano.rpc.response.ResponseBalance;

import org.mapstruct.InjectionStrategy;

@Mapper(componentModel="spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BalanceMapper {
	
	@Mapping(target = "pocketed", source = "pocketed")
    @Mapping(target = "pending", source = "pending")
	BalanceResponse responseBalanceToBalanceResponse(ResponseBalance responseBalance);

}
