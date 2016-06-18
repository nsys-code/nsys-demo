/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.plugin;

import java.util.ArrayList;
import java.util.List;

import org.nsys.event.Event;
import org.nsys.plugin.PluginContext;

import org.nsys.daemon.core.NsysDaemonConfig;
import org.nsys.daemon.event.DaemonStartedEvent;
import org.nsys.daemon.event.SystemStartedEvent;
import org.nsys.daemon.dataprocessor.DataProcessorConfig;
import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.daemon.plugin.AbstractManagementAgentPlugin;

import org.nsys.demo.daemon.collector.CollectorConfig;
import org.nsys.demo.daemon.collector.dataprocessor.CollectorGetDataStage;
import org.nsys.demo.daemon.collector.dataprocessor.CollectorStoreDataStage;
import org.nsys.demo.daemon.collector.dataprocessor.CollectorValidateDataStage;

/**
 * Nsys Demo Collector Plugin
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorPlugin extends AbstractManagementAgentPlugin {

	@Override
	public void load(PluginContext context) {
		getLog().debugFormat("Starting plugin %s", getName());
		CollectorConfig.loadConfig();
	}

	@Override
	public void unload(PluginContext context) {
		getLog().debugFormat("Stopped plugin %s", getName());
	}

	@Override
	public void handleEvent(PluginContext context, Event event) {
		if (event != null) {
			if (event instanceof DaemonStartedEvent) {
				// The Nsys Daemon Lite mode is used for nodes having limited system resources. 
				getLog().infoFormat("Nsys Daemon has been started successfully! Nsys Daemon Lite Mode: %s",
						NsysDaemonConfig.isNsysDaemonLite());
			}

			else if (event instanceof SystemStartedEvent) {
				getLog().info("The system is up and running!");
			}
		}
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
		stages.add(new CollectorGetDataStage());
		stages.add(new CollectorValidateDataStage());
		stages.add(new CollectorStoreDataStage());
		return stages;
	}
}