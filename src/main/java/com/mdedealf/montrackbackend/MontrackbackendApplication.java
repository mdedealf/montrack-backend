package com.mdedealf.montrackbackend;

import com.mdedealf.montrackbackend.infrastructure.config.JwtConfigProperties;
import com.mdedealf.montrackbackend.infrastructure.config.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtConfigProperties.class, RsaKeyConfigProperties.class})
public class MontrackbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MontrackbackendApplication.class, args);
	}

}
