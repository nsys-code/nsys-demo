/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nsys.demo.portal.webapp.PortalConfig;

/**
 * Nsys Demo API Utils
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoApiUtils {

	public static Map<String, String> getHeaders(final HttpServletRequest request) {
		Map<String, String> headers = new HashMap<String, String>();

		if (request != null) {
			headers.put("X-Nsys-Demo-API-ServerName", request.getServerName());
		}

		headers.put("X-Nsys-Demo-API-Version", PortalConfig.getVersion());
		headers.put("X-Nsys-Demo-API-BuildNumber", PortalConfig.getBuildNumber());
		return headers;
	}
}