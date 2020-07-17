package com.nanocommunicator.nano.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.oczadly.karl.jnano.model.work.WorkDifficulty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class TelemetryResponse {

	@ApiModelProperty(example="51632193")
	private long blockCount;
	
	@ApiModelProperty(example="51632193")
    private long cementedCount;
	
	@ApiModelProperty(example="0")
    private long uncheckedCount;
	
	@ApiModelProperty(example="1383762")
    private long accountCount;
	
	@ApiModelProperty(example="10485760")
    private int bandwidthCap;
	
	@ApiModelProperty(example="269")
    private int peerCount;
	
	@ApiModelProperty(example="18")
    private int protocolVersion;
	
	@ApiModelProperty(example="269718")
    private long uptime;
	
	@ApiModelProperty(example="991CF190094C00F0B68E2E5F75F6BEE95A2E0BD93CEAA4A6734DB9F19B728948")
    private String genesisBlockHash;
	
	@ApiModelProperty(example="21")
    private int majorVersion;
	
	@ApiModelProperty(example="1")
    private int minorVersion;
	
	@ApiModelProperty(example="0")
    private int patchVersion;
	
	@ApiModelProperty(example="0")
    private int preReleaseVersion;
	
	@ApiModelProperty(example="0")
    private int maker;
	
	@ApiModelProperty(example="1594853667600")
    private long timestamp;
	
	@ApiModelProperty(example="{ " +
	       " 'asHexadecimal': 'ffffffc000000000', " +
	       " 'asLong': -274877906944  }" )
    private WorkDifficulty activeDifficulty;
}
