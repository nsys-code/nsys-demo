/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.portal.webapp.plugin;

import org.nsys.event.Event;
import org.nsys.plugin.PluginContext;
import org.nsys.daemon.event.SystemStartedEvent;
import org.nsys.daemon.plugin.AbstractManagementAgentPlugin;
import org.nsys.portal.event.PortalStartedEvent;
import org.nsys.demo.portal.webapp.NsysDemoConfig;

/**
 * Nsys Demo Portal Main Plugin
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class PortalPlugin extends AbstractManagementAgentPlugin {

	@Override
	public void load(PluginContext context) {
		log.debugFormat("Starting plugin %s", getName());
		NsysDemoConfig.loadConfig();
	}

	@Override
	public void unload(PluginContext context) {
		log.debugFormat("Stopped plugin %s", getName());
	}

	@Override
	public void handleEvent(PluginContext context, Event event) {
		if (event != null) {
			if (event instanceof PortalStartedEvent) {
				log.info("Nsys Portal has been started successfully!");
			}

			else if (event instanceof SystemStartedEvent) {
				log.info("The system is up and running!");
			}
		}
	}
}