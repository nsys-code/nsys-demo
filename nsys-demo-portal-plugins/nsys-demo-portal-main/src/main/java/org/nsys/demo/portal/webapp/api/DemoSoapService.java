/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.nsys.daemon.model.Status;

/**
 * Nsys Demo SOAP (Simple Object Access protocol) Service Interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@WebService
public interface DemoSoapService {

	@WebMethod
	Status getStatus() throws DemoException;

}