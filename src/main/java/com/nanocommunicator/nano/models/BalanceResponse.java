package com.nanocommunicator.nano.models;

import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel
public class BalanceResponse {
	
	@ApiModelProperty(example="400")
    private BigInteger pocketed;
	
	@ApiModelProperty(example="100")
    private BigInteger pending;

}
