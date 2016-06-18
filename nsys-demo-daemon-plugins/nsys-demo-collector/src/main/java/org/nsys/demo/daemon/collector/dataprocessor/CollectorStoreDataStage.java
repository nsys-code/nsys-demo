/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.daemon.dataprocessor.AbstractDataProcessorStage;
import org.nsys.daemon.dataprocessor.DataProcessingThread;

/**
 * Nsys Demo Collector StoreData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorStoreDataStage extends AbstractDataProcessorStage {

	@Override
	public boolean process(final NeuralBag bag, final DataProcessingThread thread) {
		getLog().debug("Entering CollectorStoreDataStage stage...");

		getLog().info("Storing Collector data to database...");

		getLog().debug("Exiting CollectorStoreDataStage stage...");

		return true;
	}
}