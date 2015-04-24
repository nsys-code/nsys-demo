/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.daemon.demo.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;
import org.nsys.logging.Log;

/**
 * Demo ValidateData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DemoValidateDataStage implements DataProcessorStage {
	private static final Log log = new Log(DemoValidateDataStage.class);
	
	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering DemoValidateDataStage stage...");
		
		log.info("Validating Demo data...");
		 
		log.debug("Exiting DemoValidateDataStage stage...");
		 
		return true;
	}
}