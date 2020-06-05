package com.rawal.Todos.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class LocalDateStringConverter implements DynamoDBTypeConverter<String, LocalDate> {

	@Override
	public String convert(LocalDate date) {
		return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	@Override
	public LocalDate unconvert(String dateStr) {
		return LocalDate.parse(dateStr);
	}
}