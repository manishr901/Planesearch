package com.cgi.learning.common;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {

	private static final String PROPERTIES_FILE = "app.properties";

	private static final Properties appProperties;

	static {
		appProperties = readProperties();
	}

	private static Properties readProperties() {

		Properties properties = new Properties();
		try {
			properties.load(AppProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return properties;
	}

	public static String get(String key) {

		return appProperties.getProperty(key);
	}

	public static String get(String key, String defaultValue) {
		String value = appProperties.getProperty(key);
		if (null == value) {
			value = defaultValue;
		}
		return value;
	}

}
