/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.daemon.demo;

import java.util.Properties;

import org.nsys.logging.Log;
import org.nsys.util.ConfigurationManager;

/**
 * Nsys Demo Configuration
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class NsysDemoConfig {
	private static final Log log = new Log(NsysDemoConfig.class);

	public static final String CONFIG_NAME = "nsys-demo.cfg";
	public static final String VERSION = "nsys.demo.version";
	
	public static void loadConfig() {
		ConfigurationManager config = ConfigurationManager.getInstance();
		
		Properties props = config.loadConfig(String.format("/%s", CONFIG_NAME), NsysDemoConfig.class);
		
		if (props != null) {
			config.merge(props);
		}		
	}

	public static String getVersion() {
		String version = ConfigurationManager.getInstance().getProperty(VERSION);
		
		String[] data = version.replace(".", ":").split(":");
				
		if (data != null && data.length == 4) {
			version = String.format("%s.%s.%s", data[0], data[1], data[2]);
		}
		
		return version;
	}
	
	public static String getBuildNumber() {
		String version = ConfigurationManager.getInstance().getProperty(VERSION);
		
		String[] data = version.replace(".", ":").split(":");
				
		if (data != null && data.length == 4 && !data[3].equals("0")) {
			return String.format("%s", data[3]);
		}
		
		return "unknown";
	}	
}