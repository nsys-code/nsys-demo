/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.servlet.http.HttpServletRequest;

import org.nsys.daemon.model.Status;

/**
 * Nsys Demo Collector API Service interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public interface CollectorApiService {

	Status getStatus(final HttpServletRequest request);

}