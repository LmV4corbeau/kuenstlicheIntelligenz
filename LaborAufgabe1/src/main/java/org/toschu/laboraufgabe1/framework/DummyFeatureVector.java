package org.toschu.laboraufgabe1.framework;

public class DummyFeatureVector implements FeatureVector {

	private Concept concept;
	private int[] feature = new int[3];
	
	DummyFeatureVector(int a, int b, int c, Concept d){
		feature[0] = a;
		feature[1] = b;
		feature[2] = c;
		concept = d;
	}
	
	
	
	@Override
	public Concept getConcept() {
		
		return concept;
	}

	@Override
	public int getNumFeatures() {
		return 3;
	}

	@Override
	public int getFeatureValue(int i) {
		return feature[i];
	}

}
