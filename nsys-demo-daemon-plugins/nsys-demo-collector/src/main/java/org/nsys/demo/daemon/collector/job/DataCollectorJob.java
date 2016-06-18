/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.job;

import java.util.HashMap;
import java.util.Map;

import org.nsys.core.NeuralBag;
import org.nsys.daemon.core.HostNode;
import org.nsys.daemon.scheduler.job.AbstractJob;

/**
 * Nsys Demo Data Collector job
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DataCollectorJob extends AbstractJob {

    public static final String DATA_PROCESSOR_CONFIG = "nsys-demo-data-collector";

	public void execute(Map<String, Object> jobDataMap) {
		getLog().info("Collecting data...");

		for (int i = 0; i < 10; i++) {
			String payload = String.format("{\"name\": \"This is a message for host node!\", \"id\": %d}", (i + 1));
			sendDataToLocalDataProcessor(payload);
		}

		/*for (int i = 0; i < 10; i++) {
			String payload = String.format("{\"name\": \"This is a message for host node!\", \"id\": %d}", (i + 1));
			sendDataToRemoteDataProcessor(payload);
		}*/

		/*for (int i = 0; i < 10; i++) {
			String payload = String.format("{\"name\": \"This is a message for host node!\", \"id\": %d}", (i + 1));
			sendDataToRemoteNode(payload);
		}*/
	}

	protected void sendDataToLocalDataProcessor(final String payload) {
		getNodeRepository().sendBag(DATA_PROCESSOR_CONFIG, getBag(payload));
	}

	protected void sendDataToRemoteDataProcessor(final String payload) {
		HostNode node = HostNode.create(getRemoteHost(), "/api/daemon/v1", getApiKey());
		getNodeRepository().sendBag(node, DATA_PROCESSOR_CONFIG, getBag(payload));
	}

	protected void sendDataToRemoteNode(final String payload) {
		String path = String.format("/api/daemon/v1/dp/pipeline/%s", DATA_PROCESSOR_CONFIG);
		HostNode node = HostNode.create(getRemoteHost(), path, getApiKey());
		getNodeRepository().sendBag(node, getBag(payload).toJSON());
	}

	protected NeuralBag getBag(String payload) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("data-type", "random");
		headers.put("sender", "generator");
		return NeuralBag.createBag(headers, payload);
	}

	protected String getRemoteHost() {
		return "localhost";
	}

	protected String getApiKey() {
		return "abc";
	}
}