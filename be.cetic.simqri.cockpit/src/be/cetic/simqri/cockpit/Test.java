package be.cetic.simqri.cockpit;

import be.cetic.simqri.metamodel.Model;

import be.cetic.simqri.simulator.mapping.SimQRiSirius;

public class Test {
	public static void test(Model model) {
		SimQRiSirius sim = new SimQRiSirius(100, false, null, false);
		sim.fillModelWithSiriusData(model);
	}
	
}
