package com.goeuro;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goeuro.csv.CsvFileWriter;
import com.goeuro.csv.PositionCsvAdapter;
import com.goeuro.model.Position;
import com.goeuro.rest.PositionRestTemplate;

@Component
public class GoEuroAPIClient {
	
	private static final Logger logger = LoggerFactory.getLogger(GoEuroAPIClient.class);
	
	@Autowired
	private PositionRestTemplate positionRestTemplate;
	
	@Autowired
	private PositionCsvAdapter csvAdapter;
	
	public void executeQuery(String queryString) throws Exception {
		List<Position> positions = positionRestTemplate.getPositionsByString(queryString);
		String csvFileName = queryString.concat("_").concat(String.valueOf(System.currentTimeMillis()).concat(".csv"));
		logger.info(String.format("Creating CSV file: %s", csvFileName));
		CsvFileWriter.writePositionCsvFile(csvFileName, positions, csvAdapter);
	}

}
