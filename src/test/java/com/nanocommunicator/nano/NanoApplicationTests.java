package com.nanocommunicator.nano;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.nanocommunicator.nano.models.BalanceResponse;
import com.nanocommunicator.nano.models.PeersResponse;

import uk.oczadly.karl.jnano.rpc.response.ResponsePeers;
import uk.oczadly.karl.jnano.rpc.response.ResponsePeers.PeerInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.Map;


@RunWith(MockitoJUnitRunner.class)
class NanoApplicationTests {
	
	@Mock
	Map<String , PeerInfo> result;
	
	@Mock
	BalanceResponse mockBalanceResponse;
	
	@Mock
    ResponsePeers responsePeers;
	
	@InjectMocks
	PeersResponse peersResponse;
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Test
	void BalanceResponse() {
		
		when(mockBalanceResponse.getPending()).thenReturn( BigInteger.valueOf(20));
		when(mockBalanceResponse.getPocketed()).thenReturn( BigInteger.valueOf(20));
		
		BigInteger pending = mockBalanceResponse.getPending();
		BigInteger pocket = mockBalanceResponse.getPocketed();
		
		assertEquals(BigInteger.valueOf(20), pending);
		assertEquals(BigInteger.valueOf(20), pocket);
		
	}
	
	@Test
	void PeersResponseTest() {
		
		Map<String , PeerInfo> result = peersResponse.getPeers();
		
		assertNotNull(result);
		
	}
	

}
