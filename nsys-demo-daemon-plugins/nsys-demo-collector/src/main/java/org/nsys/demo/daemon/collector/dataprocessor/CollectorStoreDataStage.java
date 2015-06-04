/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.logging.Log;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;

/**
 * Collector StoreData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorStoreDataStage implements DataProcessorStage {
	private static final Log log = new Log(CollectorStoreDataStage.class);

	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering CollectorStoreDataStage stage...");
		
		log.info("Storing Collector data to database...");
		 
		log.debug("Exiting CollectorStoreDataStage stage...");
		 
		return true;
	}
}