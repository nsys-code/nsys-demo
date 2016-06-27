/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector;

import java.util.Properties;

import org.nsys.util.ConfigurationManager;

/**
 * Nsys Demo Collector Configuration
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorConfig {

	public static final String CONFIG_NAME = "nsys-demo-collector.cfg";
	public static final String CONFIG_NAME_INTERNAL = "nsys-demo-collector.cfg.internal";
	public static final String VERSION = "nsys.demo.collector.version";

	public static void loadConfig() {
		ConfigurationManager config = ConfigurationManager.getInstance();

		Properties props = config.loadConfig(String.format("/%s", CONFIG_NAME), CollectorConfig.class);

		if (props != null) {
			config.merge(props);
		}

		props = config.loadConfig(String.format("/%s", CONFIG_NAME_INTERNAL), CollectorConfig.class);

		if (props != null) {
			config.merge(props, true);
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
}