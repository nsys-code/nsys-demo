/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.servlet.http.HttpServletRequest;

import org.nsys.logging.Log;
import org.nsys.daemon.model.Status;
import org.nsys.daemon.system.SystemModeType;

/**
 * Nsys Demo API Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoApiServiceImpl implements DemoApiService {
	private final Log log = Log.getLogger(DemoApiServiceImpl.class);
	private static final DemoApiService singleton = new DemoApiServiceImpl();

	private DemoApiServiceImpl() {
	}

	public static DemoApiService getInstance() {
		return singleton;
	}

	protected Log getLog() {
		return log;
	}

	@Override
	public Status getStatus(final HttpServletRequest request) {
		Status status = new Status();
		status.setSystemMode(SystemModeType.MAINTENANCE);
		return status;
	}
}