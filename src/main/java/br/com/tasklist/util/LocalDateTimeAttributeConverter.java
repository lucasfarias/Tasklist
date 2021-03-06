package br.com.tasklist.util;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {


   //LocalDateTime -> Timestamp
   @Override
   public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {

   	if(localDateTime != null)
   		return Timestamp.valueOf(localDateTime);

   	return null;

   }

   //Timestamp -> LocalDateTime 
   @Override
   public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {

   	if(timestamp != null)
   		return timestamp.toLocalDateTime();

   	return null;
   }
}