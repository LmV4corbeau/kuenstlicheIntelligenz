package org.toschu.laboraufgabe1.framework;

import java.util.List;


/** a dummy class to implement a learner that will not do any 
 * learning and will the think, everything corresponds to 
 * the same concept. 
 * 
 * @author gr
 *
 */
public class DummyLearner implements Learner {

	@Override
	public void learn(List<FeatureVector> trainingSet) {
		// wir machen gar nichts und bleiben dumm

	}

	@Override
	public Concept classify(FeatureVector example) {
		// weil wir nichts gelernt haben glauben wir, alles sind Stopschilder
		return Concept.Stop;
	}

}
