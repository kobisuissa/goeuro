package com.goeuro.csv;

public enum CsvConstants {
	
	COMMA_DELIMITER(","),
	NEW_LINE_SEPARATOR("\n"),
	POSITION_FILE_HEADER("_type, _id, name, type, latitude, longitude");
	
	private String value;
	
	private CsvConstants(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}

}
