/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import org.nsys.daemon.model.Status;
import org.nsys.daemon.server.AbstractWebService;

/**
 * Nsys Demo Collector SOAP (Simple Object Access protocol) Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@WebService(endpointInterface = "org.nsys.demo.daemon.collector.api.CollectorSoapService", serviceName = "NsysDemoCollectorService")
@Service("collectorSoapService")
public class CollectorSoapServiceImpl extends AbstractWebService implements CollectorSoapService {
    protected CollectorApiService api;

	public CollectorApiService getApi() {
		if (api == null) {
			api = CollectorApiServiceImpl.getInstance();
		}

		return api;
	}

	@Override
	public Status getStatus() throws CollectorException {
		Status status = null;

		try {
			status = getApi().getStatus(getRequest());

		} catch (final Exception ex) {
			String errorMsg = "Unable to get Nsys Demo Collector status!";
			getLog().error(String.format("%s Error: %s", errorMsg, ex.getMessage()), ex);
			throw new CollectorException(errorMsg, ex.getMessage());
		}

		return status;
	}
}