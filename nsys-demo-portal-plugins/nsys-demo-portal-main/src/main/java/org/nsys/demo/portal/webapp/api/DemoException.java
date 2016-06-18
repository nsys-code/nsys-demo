/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

import org.nsys.daemon.model.ErrorData;

/**
 * Nsys Demo Exception
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@SuppressWarnings("serial")
@WebFault(name = "NsysDemoException")
@XmlAccessorType(XmlAccessType.FIELD)
public class DemoException extends Exception {
	private final String reason;
	private final ErrorData errorData;

	public DemoException() {
		this(null, null, null);
	}

	public DemoException(final String message) {
		this(message, null, null);
	}

    public DemoException (final String message, final String reason) {
    	this(message, reason, null);
    }

    public DemoException (final String message, final ErrorData errorData) {
    	this(message, null, errorData);
    }

    public DemoException (final String message, final String reason, final ErrorData errorData) {
        super(message);
        this.reason = reason;
        this.errorData = errorData;
    }

	public String getReason() {
		return reason;
	}

	public ErrorData getErrorData() {
		return errorData;
	}
}