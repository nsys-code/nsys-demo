/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

/**
 * Nsys Demo RESTful Service interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public interface DemoRestService {

	Response getStatus(final HttpServletRequest request);

}