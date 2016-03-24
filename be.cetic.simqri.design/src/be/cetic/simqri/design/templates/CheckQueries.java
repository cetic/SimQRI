package be.cetic.simqri.design.templates;

import be.cetic.simqri.metamodel.Model;
import be.cetic.simqri.metamodel.Query;

public class CheckQueries {
	public boolean queriesAreOk(Model model) {
		boolean ok = true;
		for(Query q : model.getQuery()) {
			if (q.getValue().contains("bad values"))
				ok = false;
		}
		return ok;
	}
}
