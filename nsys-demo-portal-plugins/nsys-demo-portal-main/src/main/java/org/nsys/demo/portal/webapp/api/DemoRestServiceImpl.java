/* Copyright 2012, 2017 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import org.nsys.logging.Log;
import org.nsys.util.RestUtils;
import org.nsys.daemon.model.ErrorData;

/**
 * Nsys Demo RESTful Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@Path("/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Service("demoRestService")
public class DemoRestServiceImpl implements DemoRestService {
    protected final Log log = Log.getLogger(DemoRestServiceImpl.class);
    protected DemoApiService api;

    @Context
    private SecurityContext securityContext;

	protected Log getLog() {
		return log;
	}

	public DemoApiService getApi() {
		if (api == null) {
			api = DemoApiServiceImpl.getInstance();
		}

		return api;
	}

	public SecurityContext getSecurityContext() {
		return securityContext;
	}

	@GET
	@Path("/status")
	@Override
	public Response getStatus(@Context final HttpServletRequest request) {
		org.nsys.daemon.model.Status status = null;

		try {
			status = getApi().getStatus(request);

		} catch (final Exception ex) {
			String errorMsg = String.format("Unable to get Nsys Demo status! Error: %s", ex.getMessage());
			getLog().error(errorMsg, ex);
			return RestUtils.toResponse(ErrorData.create(1, errorMsg), Status.BAD_REQUEST, DemoApiUtils.getHeaders(request));
		}

		return RestUtils.toResponse(status, Response.Status.OK, DemoApiUtils.getHeaders(request));
	}
}