package com.goeuro.csv;

import org.springframework.stereotype.Component;

import com.goeuro.model.Position;

@Component
public class PositionCsvAdapter implements CsvAdapter {
	
	private Position position;
	
	public PositionCsvAdapter() {
		
	}

	@Override
	public String getCsvLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(position.get_type());
		sb.append(CsvConstants.COMMA_DELIMITER.value());
		sb.append(position.get_id());
		sb.append(CsvConstants.COMMA_DELIMITER.value());
		sb.append(position.getName());
		sb.append(CsvConstants.COMMA_DELIMITER.value());
		sb.append(position.getType());
		sb.append(CsvConstants.COMMA_DELIMITER.value());
		sb.append(position.getGeo_position().getLatitude());
		sb.append(CsvConstants.COMMA_DELIMITER.value());
		sb.append(position.getGeo_position().getLongitude());
		return sb.toString();
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String getCsvHeaderLine() {
		return CsvConstants.POSITION_FILE_HEADER.value();
	}

}
