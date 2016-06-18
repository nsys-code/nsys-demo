/* Copyright 2012, 2016 Nsys.org - Tomas Hrdlicka <tomas@hrdlicka.co.uk>. All rights reserved.
 */

package org.nsys.demo.daemon.collector.dataprocessor.data;

import org.nsys.core.NeuralBag;
import org.nsys.core.NeuralBagName;
import org.nsys.daemon.dataprocessor.AbstractDataProcessorStage;
import org.nsys.daemon.dataprocessor.DataProcessingThread;

/**
 * Nsys Demo Data Collector - ProcessData stage
 *
 * @author Tomas Hrdlicka <tomas@hrdlicka.co.uk>
 * @see <a href="http://nsys.org">Nsys</a>
 */
public class DataCollectorProcessDataStage extends AbstractDataProcessorStage {

	@Override
	public boolean process(final NeuralBag bag, final DataProcessingThread thread) {
		getLog().debug("Entering CollectorProcessData stage...");

		if (bag.containsKey(NeuralBagName.PAYLOAD)) {
			getLog().debugFormat("Payload: %s", bag.get(NeuralBagName.PAYLOAD));

		} else {
			getLog().debug("NeuralBag does not contain attribute PAYLOAD!");
		}

		getLog().debug("Exiting CollectorProcessData stage...");

		return true;
	}
}