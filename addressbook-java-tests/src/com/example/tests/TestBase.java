package com.example.tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected Logger log = Logger.getLogger("TEST");
	
	protected static ApplicationManager app;

	@BeforeMethod
	@BeforeClass
	@Parameters({"configFile"}) 
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile");
		}
		if (configFile == null) {
			configFile = System.getenv("configFile");
		}
		if (configFile == null) {
			configFile = "test-input\\application.properties";
		}
		Properties properties = new Properties();
		properties.load(new FileReader(configFile));
		log.info("set up start");
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
		log.info("set up finish");
	}
	
	@AfterTest
	public void TearDown() throws Exception {
		log.info("tear down start");
		ApplicationManager.getInstance().stop();
		log.info("tear down finish");
	}
}
