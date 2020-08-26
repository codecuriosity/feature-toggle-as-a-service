package org.ft.samples.client;

import org.ft.client.annotations.EnableFeatureToggleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Prajwal Das
 */
@SpringBootApplication
@EnableFeatureToggleClient
public class FeatureToggleSampleClientApp
{
	public static void main(String[] args) {
		SpringApplication.run(FeatureToggleSampleClientApp.class, args);
	}
}