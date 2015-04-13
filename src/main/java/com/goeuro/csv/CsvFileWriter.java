package com.goeuro.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.GoEuroAPIClient;
import com.goeuro.model.Position;

public class CsvFileWriter {
	
	private static final Logger logger = LoggerFactory.getLogger(CsvFileWriter.class);
	
	public static void writePositionCsvFile(String fileName, List<Position> positions, CsvAdapter csvAdapter) throws Exception {
		
		PositionCsvAdapter positionCsvAdapter = (PositionCsvAdapter) csvAdapter;
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			fileWriter.append(CsvConstants.POSITION_FILE_HEADER.value());
			
			fileWriter.append(CsvConstants.NEW_LINE_SEPARATOR.value());
			
			for (Position position : positions) {				
				positionCsvAdapter.setPosition(position);
				fileWriter.append(positionCsvAdapter.getCsvLine());
				fileWriter.append(CsvConstants.NEW_LINE_SEPARATOR.value());
			}

			logger.info(String.format("CSV file was created successfully with %s records", positions.size()));
			
		} catch (Exception e) {
			logger.error("Error in CsvFileWriter!");
			throw e;
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				logger.error("Error while flushing/closing fileWriter!");
                throw e;
			}
			
		}
	}
}