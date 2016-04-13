package be.cetic.simqri.cockpit.main;

import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.simulator.mapping.SimQRiSirius;

public class Simulation {
	
	public static void launch(Model model) {
		SimQRiSirius sim = new SimQRiSirius(1000, true);
		sim.fillModelWithSiriusData(model);
		sim.simulateOneShot();
	}
}
