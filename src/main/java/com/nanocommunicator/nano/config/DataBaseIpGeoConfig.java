package com.nanocommunicator.nano.config;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.maxmind.geoip2.DatabaseReader;

@Configuration
public class DataBaseIpGeoConfig {
	
	@Value("${geo.database}")
	private String dataBaseName;
	
	@Bean
	public DatabaseReader prepareDatabaseReader() throws IOException {
		
		Resource database = new ClassPathResource(dataBaseName);
		
		return new DatabaseReader
				  .Builder(database.getInputStream())
			      .build();
		
	}

}
