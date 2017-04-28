package com.cgi.learning.common;

import java.io.IOException;
import java.text.MessageFormat;

import org.codehaus.jackson.map.ObjectMapper;

public class FormattingUtils {

	public static String format(String formattableStr, Object[] args) {

		return MessageFormat.format(formattableStr, args);
	}

	public String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
