package com.it355.entities.data;

public enum Tehnologija {
	DvaD("2D"), TriD("3D");
	
	private final String value;

	private Tehnologija(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
