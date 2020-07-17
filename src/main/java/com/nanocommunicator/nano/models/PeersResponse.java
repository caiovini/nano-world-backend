package com.nanocommunicator.nano.models;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.oczadly.karl.jnano.rpc.response.ResponsePeers.PeerInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PeersResponse {
	
	@ApiModelProperty(example= "peers: { '[::ffff:85.214.189.238]:7075': "
			                        + "{ 'protocolVer': 18, 'nodeId': 'node_3kb47xkpnymjqfsx9ino8na57fi558jdsqje66wo169qkxoprjaa6o4dnawp',"
			                        + "  'type': 'tcp' ] }")
	private Map<String, PeerInfo> peers;

}
