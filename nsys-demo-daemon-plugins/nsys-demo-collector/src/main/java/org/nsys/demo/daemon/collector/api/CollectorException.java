/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

import org.nsys.daemon.model.ErrorData;

/**
 * Nsys Demo Collector Exception
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
@SuppressWarnings("serial")
@WebFault(name = "NsysDemoCollectorException")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectorException extends Exception {
	private final String reason;
	private final ErrorData errorData;

	public CollectorException() {
		this(null, null, null);
	}

	public CollectorException(final String message) {
		this(message, null, null);
	}

    public CollectorException (final String message, final String reason) {
    	this(message, reason, null);
    }

    public CollectorException (final String message, final ErrorData errorData) {
    	this(message, null, errorData);
    }

    public CollectorException (final String message, final String reason, final ErrorData errorData) {
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