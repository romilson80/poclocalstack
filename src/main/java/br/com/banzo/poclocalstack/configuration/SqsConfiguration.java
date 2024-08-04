//package br.com.banzo.poclocalstack.configuration;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.sqs.SqsAsyncClient;
//
//import java.net.URI;
//
//
//@Configuration
//public class SqsConfiguration {
//
//    @Value("${sqs.endpoint}")
//    public String endpoint;
//
//    @Bean
//    public SqsAsyncClient sqsAsyncClient() {
//        return SqsAsyncClient.builder()
//                .endpointOverride(URI.create(endpoint))
//                .region(Region.US_EAST_1)
//                .build();
//    }
//
//}
