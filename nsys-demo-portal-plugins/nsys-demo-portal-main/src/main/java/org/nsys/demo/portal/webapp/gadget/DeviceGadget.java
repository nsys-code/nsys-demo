/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.gadget;

import java.util.HashMap;
import java.util.Map;

import org.nsys.portal.gadget.AbstractGadget;

/**
 * Device Gadget
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DeviceGadget extends AbstractGadget {

	public static final String TEMPLATE = "/templates/gadget/devices.vm";
	
	public DeviceGadget() {
		setTemplate(TEMPLATE);
	}

	@Override
	protected Map<String, Object> createVelocityParams(Map<String, Object> context) {
		Map<String, Object> velocityParams = new HashMap<String, Object>();
		return velocityParams;
	}
}