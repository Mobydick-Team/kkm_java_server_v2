package com.kkm.kkm_server_v2.global.infra.S3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class AwsS3Config {

    private final AwsProperties awsProperties;

    @Bean
    public AmazonS3Client amazonS3Client() {
        log.info("access : " + awsProperties.getAccessKey());
        log.info("refresh : " + awsProperties.getSecretKey());
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsProperties.getAccessKey(), awsProperties.getSecretKey());
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(awsProperties.getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}