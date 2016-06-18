/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.servlet.http.HttpServletRequest;

import org.nsys.daemon.model.Status;

/**
 * Nsys Demo API Service interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public interface DemoApiService {

	Status getStatus(final HttpServletRequest request);

}