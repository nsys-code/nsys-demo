/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.logging.Log;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;

/**
 * Collector GetData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorGetDataStage implements DataProcessorStage {
	private static final Log log = new Log(CollectorGetDataStage.class);
	
	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering CollectorGetDataStage stage...");
		
		log.info("Getting Collector data...");
		 
		log.debug("Exiting CollectorGetDataStage stage...");
		 
		return true;
	}
}