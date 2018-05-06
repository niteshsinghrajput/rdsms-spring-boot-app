package com.rdsms.utils;

import java.io.IOException;
import java.sql.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateConvertor extends StdDeserializer<Date>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomDateConvertor() {
        this(null);
    }

    public CustomDateConvertor(Class<?> vc) {
        super(vc);
    }

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException {
		String strDate = jsonparser.getText();
		System.out.println("String date is : "+strDate);
		Date date = null;
		
        try {
            	date = DateUtils.convertStringToDate(strDate);
            	System.out.println("After converting date is : "+date);
        } catch (Exception e) {
            
        }
		return date;
	}


}
