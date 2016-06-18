/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nsys.demo.daemon.collector.CollectorConfig;

/**
 * Nsys Demo Collector API Utils
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorApiUtils {

	public static Map<String, String> getHeaders(final HttpServletRequest request) {
		Map<String, String> headers = new HashMap<String, String>();

		if (request != null) {
			headers.put("X-Nsys-Demo-Collector-API-ServerName", request.getServerName());
		}

		headers.put("X-Nsys-Demo-Collector-API-Version", CollectorConfig.getVersion());
		headers.put("X-Nsys-Demo-Collector-API-BuildNumber", CollectorConfig.getBuildNumber());
		return headers;
	}
}