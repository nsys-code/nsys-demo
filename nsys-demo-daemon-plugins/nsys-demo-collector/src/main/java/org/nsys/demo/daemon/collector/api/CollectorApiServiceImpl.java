/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.servlet.http.HttpServletRequest;

import org.nsys.logging.Log;
import org.nsys.daemon.model.Status;
import org.nsys.daemon.system.SystemModeType;

/**
 * Nsys Demo Collector API Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorApiServiceImpl implements CollectorApiService {
	private final Log log = Log.getLogger(CollectorApiServiceImpl.class);
	private static final CollectorApiService singleton = new CollectorApiServiceImpl();

	private CollectorApiServiceImpl() {
	}

	public static CollectorApiService getInstance() {
		return singleton;
	}

	protected Log getLog() {
		return log;
	}

	@Override
	public Status getStatus(final HttpServletRequest request) {
		Status status = new Status();
		status.setSystemMode(SystemModeType.SAFEMODE);
		return status;
	}
}