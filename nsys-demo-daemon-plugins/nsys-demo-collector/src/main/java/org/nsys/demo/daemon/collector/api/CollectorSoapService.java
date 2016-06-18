/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.nsys.daemon.model.Status;

/**
 * Nsys Demo Collector SOAP (Simple Object Access protocol) Service Interface
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@WebService
public interface CollectorSoapService {

	@WebMethod
	Status getStatus() throws CollectorException;

}