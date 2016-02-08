package com.example.fw;

import java.util.Properties;

public class ApplicationManager {
	private static ApplicationManager singleton;
	
	private Properties properties;

	private FolderHelper folderHelper;
	
	public static ApplicationManager getInstance() {
		if(singleton == null) {
			return new ApplicationManager();
		}
		return singleton;
	}

	public void stop() {
		
	}
	
	public void setProperties(Properties properties) {
		singleton.properties = properties;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;  
	}
}
