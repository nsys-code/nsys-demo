/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 * Nsys Demo Collector RESTful Service interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public interface CollectorRestService {

	Response getStatus(final HttpServletRequest request);

}