package org.toschu.laboraufgabe1.framework;
import java.util.List;

public interface Learner {
	/** The training method, that chances the internal state of the learner such that 
	 * it will classify examples of a similar set (i.e. the testSet better.
	 * 
	 * @param trainingSet contains feature vectors and corresponding concepts 
	 * to provide experience to learn from  
	 */
	void learn(List<FeatureVector> trainingSet);
	
	/**
	 * find the concept of the example from the internal knowledge of the lerner
	 * this method must not consider example.getConcept() at all!!
	 * 
	 * @param example: is a feature vector
	 * @return the concept of the examplke as learned by this before
	 */
	Concept classify(FeatureVector example);
}
