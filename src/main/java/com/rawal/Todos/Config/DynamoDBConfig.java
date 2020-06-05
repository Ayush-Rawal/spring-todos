package com.rawal.Todos.Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.rawal.Todos.Models.TodoRepository;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.socialsignin.spring.data.dynamodb.mapping.DynamoDBMappingContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = TodoRepository.class, mappingContextRef = "dynamoDBMappingContext")
public class DynamoDBConfig {

	@Value("${amazon.aws.accessKey}")
	private String AWSAccessKey;

	@Value("${amazon.aws.secretKey}")
	private String AWSSecretKey;

	@Value("${amazon.aws.dynamoDBEndpoint}")
	private String dynamoDBEndpoint;

	@Value("${amazon.aws.region}")
	private String AWSRegion;

	@Bean
	public DynamoDBMapperConfig dynamoDBMapperConfig() {
		return DynamoDBMapperConfig.DEFAULT;
	}

	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.US_EAST_1)
			// .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDBEndpoint, AWSRegion))	
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(AWSAccessKey, AWSSecretKey)))
			.build();
	}

	@Bean
	public DynamoDBMappingContext dynamoDBMappingContext() {
		return new DynamoDBMappingContext();
	}
}