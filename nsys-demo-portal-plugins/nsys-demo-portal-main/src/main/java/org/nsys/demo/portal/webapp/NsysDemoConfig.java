/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp;

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
	public static final String PLUGIN_KEY = "nsys.demo.pluginKey";

	public static final String TWITTER_DEBUG_ENABLED = "twitter4j.debug";
	public static final String TWITTER_CONSUMER_KEY = "twitter4j.oauth.consumerKey";
	public static final String TWITTER_CONSUMER_SECRET = "twitter4j.oauth.consumerSecret";

	public static void loadConfig() {
		ConfigurationManager config = ConfigurationManager.getInstance();

		Properties props = config.loadConfig(String.format("/%s", CONFIG_NAME), NsysDemoConfig.class);

		if (props != null) {
			config.merge(props);
		}
	}

	public static String getVersion() {
		String version = ConfigurationManager.getInstance().getProperty(VERSION);
		return ConfigurationManager.getVersion(version);
	}

	public static String getBuildNumber() {
		String version = ConfigurationManager.getInstance().getProperty(VERSION);
		return ConfigurationManager.getBuildNumber(version);
	}

	public static String getPluginKey() {
		return ConfigurationManager.getInstance().getProperty(PLUGIN_KEY);		
	}

	public static boolean getTwitterDebugEnabled() {
		return Boolean.valueOf(ConfigurationManager.getInstance().getProperty(TWITTER_DEBUG_ENABLED));
	}

	public static String getTwitterConsumerKey() {
		return ConfigurationManager.getInstance().getProperty(TWITTER_CONSUMER_KEY);
	}

	public static String getTwitterConsumerSecret() {
		return ConfigurationManager.getInstance().getProperty(TWITTER_CONSUMER_SECRET);
	}
}