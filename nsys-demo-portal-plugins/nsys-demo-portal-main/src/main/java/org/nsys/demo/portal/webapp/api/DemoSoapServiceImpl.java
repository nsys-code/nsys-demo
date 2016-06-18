/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import org.nsys.daemon.model.Status;
import org.nsys.daemon.server.AbstractWebService;

/**
 * Nsys Demo SOAP (Simple Object Access protocol) Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@WebService(endpointInterface = "org.nsys.demo.portal.webapp.api.DemoSoapService", serviceName = "NsysDemoService")
@Service("demoSoapService")
public class DemoSoapServiceImpl extends AbstractWebService implements DemoSoapService {
    protected DemoApiService api;

	public DemoApiService getApi() {
		if (api == null) {
			api = DemoApiServiceImpl.getInstance();
		}

		return api;
	}

	@Override
	public Status getStatus() throws DemoException {
		Status status = null;

		try {
			status = getApi().getStatus(getRequest());

		} catch (final Exception ex) {
			String errorMsg = "Unable to get Nsys Demo status!";
			getLog().error(String.format("%s Error: %s", errorMsg, ex.getMessage()), ex);
			throw new DemoException(errorMsg, ex.getMessage());
		}

		return status;
	}
}