/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.daemon.demo.plugin;

import java.util.ArrayList;
import java.util.List;

import org.nsys.event.Event;
import org.nsys.plugin.PluginContext;
import org.nsys.daemon.dataprocessor.DataProcessorConfig;
import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.daemon.demo.NsysDemoConfig;
import org.nsys.daemon.demo.dataprocessor.DemoGetDataStage;
import org.nsys.daemon.demo.dataprocessor.DemoStoreDataStage;
import org.nsys.daemon.demo.dataprocessor.DemoValidateDataStage;
import org.nsys.daemon.plugin.AbstractManagementAgentPlugin;

/**
 * Nsys Daemon Demo Plugin
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
	
	@Override
	public DataProcessorConfig getDataProcessorConfig() {
		DataProcessorConfig config = new DataProcessorConfig();
		config.setRunnerJobEnabled(true);
		config.setRunnerJobDelay(60 * 1000); // starts after one minute
		config.setRunnerJobInterval((60 * 1000) * 5); // runs each 5 mins 
		return config;
	}

	@Override
	public List<DataProcessorStage> getDataProcessorStages() {
		List<DataProcessorStage> stages = new ArrayList<DataProcessorStage>();
		stages.add(new DemoGetDataStage());
		stages.add(new DemoValidateDataStage());
		stages.add(new DemoStoreDataStage());		
		return stages;
	}
}