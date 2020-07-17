package com.nanocommunicator.nano.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import com.nanocommunicator.nano.models.TelemetryResponse;

import uk.oczadly.karl.jnano.rpc.response.ResponseTelemetry;


@Mapper(componentModel="spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TelemetryMapper {

	@Mapping(target = "blockCount", source = "blockCount")
	@Mapping(target = "cementedCount", source = "cementedCount")
	@Mapping(target = "uncheckedCount", source = "uncheckedCount")
	@Mapping(target = "accountCount", source = "accountCount")
	@Mapping(target = "bandwidthCap", source = "bandwidthCap")
	@Mapping(target = "peerCount", source = "peerCount")
	@Mapping(target = "protocolVersion", source = "protocolVersion")
	@Mapping(target = "uptime", source = "uptime")
	@Mapping(target = "genesisBlockHash", source = "genesisBlockHash")
	@Mapping(target = "majorVersion", source = "majorVersion")
	@Mapping(target = "minorVersion", source = "minorVersion")
	@Mapping(target = "patchVersion", source = "patchVersion")
	@Mapping(target = "preReleaseVersion", source = "preReleaseVersion")
	@Mapping(target = "maker", source = "maker")
	@Mapping(target = "timestamp", source = "timestamp")
	@Mapping(target = "activeDifficulty", source = "activeDifficulty")
	public TelemetryResponse fromResponseTelemetryToTelemetryResponse(ResponseTelemetry responseTelemetry);
}
