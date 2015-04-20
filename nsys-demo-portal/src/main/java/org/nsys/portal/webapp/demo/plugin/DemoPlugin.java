/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.portal.webapp.demo.plugin;

import org.nsys.event.Event;
import org.nsys.plugin.PluginContext;
import org.nsys.portal.webapp.demo.NsysDemoConfig;
import org.nsys.daemon.plugin.AbstractManagementAgentPlugin;

/**
 * Nsys Portal Demo Plugin
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoPlugin extends AbstractManagementAgentPlugin {

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
	}
}