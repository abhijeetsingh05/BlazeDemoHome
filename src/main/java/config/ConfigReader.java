package config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

public class ConfigReader {

	Logger logger = Logger.getLogger(Log.class.getName());

	public static String url;
	public static String browser;
	public static String departureCity;
	public static String destinationCity;

	public static void readConfigData() throws Exception {
		ConfigReader conf = new ConfigReader();
		conf.readConfigFile();
	}

	@SuppressWarnings("static-access")
	public void readConfigFile() throws Exception {
		Properties prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\globalConfig.properties");
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);

		// used getProperty to get value from cmd
		String browser = System.getProperty("browser");
		if (browser != null) {
			this.browser = browser;
		} else {
			this.browser = prop.getProperty("browser");
		}
		
		url = prop.getProperty("url");
		departureCity=prop.getProperty("departureCity");
		destinationCity=prop.getProperty("destinationCity");
	}

}
