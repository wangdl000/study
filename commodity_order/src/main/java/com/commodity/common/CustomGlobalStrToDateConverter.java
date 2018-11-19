package com.commodity.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @author ou
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// GEL-DOCTODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
