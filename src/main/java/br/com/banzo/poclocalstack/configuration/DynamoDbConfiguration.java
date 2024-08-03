package br.com.banzo.poclocalstack.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbConfiguration {

    @Value("${sqs.endpoint}")
    public String endpoint;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient
                .builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_1)
                .build();
    }
}
