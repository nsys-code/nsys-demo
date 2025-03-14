/* Copyright 2012, 2025 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

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

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.stereotype.Service;

import org.nsys.logging.Log;
import org.nsys.util.RestUtils;
import org.nsys.daemon.model.ErrorData;
import org.nsys.daemon.server.Secured;
import org.nsys.daemon.security.AccessTokenScope;

/**
 * Nsys Demo Collector RESTful Service
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@SecurityScheme(
		name = "BearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT"
)
@OpenAPIDefinition(
		info = @Info(
				title = "Nsys Demo Collector REST API",
				version = "1.0",
				description = "Nsys Demo Collector RESTful Service",
				license = @License(name = "Apache 2.0 License", url = "https://nsys.org/license"),
				contact = @Contact(url = "https://nsys.org", name = "Nsys Platform", email = "info@nsys.org")
		),
		tags = {
				@Tag(name = "Nsys Demo Collector", description = "Nsys Demo Collector API")
		},
		servers = @Server(url = "/api/demo-collector/v1")
)
@Path("/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Service("collectorRestService")
public class CollectorRestServiceImpl implements CollectorRestService {
    protected final Log log = Log.getLogger(CollectorRestServiceImpl.class);
    protected CollectorApiService api;

    @Context
    private SecurityContext securityContext;

	protected Log getLog() {
		return log;
	}

	public CollectorApiService getApi() {
		if (api == null) {
			api = CollectorApiServiceImpl.getInstance();
		}

		return api;
	}

	public SecurityContext getSecurityContext() {
		return securityContext;
	}

	@GET
	@Path("/status")
	@Secured(value = {AccessTokenScope.READ_ONLY, AccessTokenScope.READ_WRITE, AccessTokenScope.ADMIN})
	@SecurityRequirement(name = "BearerAuth")
	@Operation(
			tags = { "Nsys Demo Collector" },
			operationId = "/api/demo-collector/v1/getStatus",
			summary = "Check the plugin status",
			description = "Returns the status of the plugin",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Status",
							content = @Content(schema = @Schema(implementation = org.nsys.daemon.model.Status.class))),
					@ApiResponse(responseCode = "400", description = "Invalid request"),
					@ApiResponse(responseCode = "401", description = "Returned if request is submitted by an anonymous user or if the access token is invalid e.g. expired")
			}
	)
	@Override
	public Response getStatus(@Context final HttpServletRequest request) {
		org.nsys.daemon.model.Status status = null;

		try {
			status = getApi().getStatus(request);

		} catch (final Exception ex) {
			String errorMsg = String.format("Unable to get Nsys Demo Collector status! Error: %s", ex.getMessage());
			getLog().error(errorMsg, ex);
			return RestUtils.toResponse(ErrorData.create(1, errorMsg), Status.BAD_REQUEST, CollectorApiUtils.getHeaders(request));
		}

		return RestUtils.toResponse(status, Response.Status.OK, CollectorApiUtils.getHeaders(request));
	}
}