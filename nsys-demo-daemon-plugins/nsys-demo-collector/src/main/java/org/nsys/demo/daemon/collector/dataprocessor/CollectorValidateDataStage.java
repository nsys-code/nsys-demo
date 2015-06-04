/* Copyright 2012, 2015 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.dataprocessor;

import org.nsys.core.NeuralBag;
import org.nsys.logging.Log;
import org.nsys.daemon.dataprocessor.DataProcessingThread;
import org.nsys.daemon.dataprocessor.DataProcessorStage;

/**
 * Collector ValidateData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class CollectorValidateDataStage implements DataProcessorStage {
	private static final Log log = new Log(CollectorValidateDataStage.class);
	
	@Override
	public boolean process(NeuralBag bag, DataProcessingThread thread) {
		log.debug("Entering CollectorValidateDataStage stage...");
		
		log.info("Validating Collector data...");
		 
		log.debug("Exiting CollectorValidateDataStage stage...");
		 
		return true;
	}
}