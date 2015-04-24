/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.daemon.demo.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.logging.Log;

/**
 * Demo StoreData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoStoreDataStage implements DataProcessorStage {
	private static final Log log = new Log(DemoStoreDataStage.class);

	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering DemoStoreDataStage stage...");
		
		log.info("Storing Demo data to database...");
		 
		log.debug("Exiting DemoStoreDataStage stage...");
		 
		return true;
	}
}