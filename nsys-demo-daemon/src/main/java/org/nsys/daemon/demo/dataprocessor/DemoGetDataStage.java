/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.daemon.demo.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.logging.Log;

/**
 * Demo GetData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoGetDataStage implements DataProcessorStage {
	private static final Log log = new Log(DemoGetDataStage.class);
	
	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering DemoGetDataStage stage...");
		
		log.info("Getting Demo data...");
		 
		log.debug("Exiting DemoGetDataStage stage...");
		 
		return true;
	}
}