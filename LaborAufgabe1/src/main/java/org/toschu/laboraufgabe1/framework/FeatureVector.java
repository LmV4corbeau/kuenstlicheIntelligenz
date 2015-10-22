package org.toschu.laboraufgabe1.framework;

import java.io.Serializable;

public interface FeatureVector extends Serializable{
	
	/** 
	 * @return the concept this feature vector represents
	 */
	Concept getConcept();
	
	/** 
	 * @return the number of features in the feature vector
	 */
	int getNumFeatures();
	
	/**
	 * 
	 * @param i the index of the feature in the vector
	 * @return the value of the feater with index i
	 */
	int getFeatureValue(int i);

}
