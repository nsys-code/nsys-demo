/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.plugin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.nsys.event.Event;
import org.nsys.system.ServiceProvider;
import org.nsys.plugin.PluginContext;
import org.nsys.util.TimeUtils;

import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.daemon.plugin.AbstractManagementAgentPlugin;
import org.nsys.daemon.scheduler.SchedulerService;

import org.nsys.demo.daemon.collector.dataprocessor.data.DataCollectorProcessDataStage;
import org.nsys.demo.daemon.collector.job.DataCollectorJob;

/**
 * Nsys Demo Data Collector Plugin
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DataCollectorPlugin extends AbstractManagementAgentPlugin {

	@Override
	public void load(PluginContext context) {
		getLog().debugFormat("Starting plugin %s", getName());

		scheduleJobs();
	}

	@Override
	public void unload(PluginContext context) {
		getLog().debugFormat("Stopped plugin %s", getName());
	}

	@Override
	public void handleEvent(PluginContext context, Event event) {
		if (event != null) {
			// Do something...
		}
	}

	@Override
	public List<DataProcessorStage> getDataProcessorStages() {
		List<DataProcessorStage> stages = new ArrayList<DataProcessorStage>();
		stages.add(new DataCollectorProcessDataStage());
		return stages;
	}

	private void scheduleJobs() {
		SchedulerService scheduler = ServiceProvider.getInstance().getServiceHost(SchedulerService.class);

		Date delay5mins = TimeUtils.addMinutes(TimeUtils.getNow(), 5);
		long repeatInterval = (60 * 1000) * 30; // 30mins

		scheduler.scheduleJob(DataCollectorJob.class, new HashMap<String, Object>(), delay5mins, repeatInterval);
	}
}