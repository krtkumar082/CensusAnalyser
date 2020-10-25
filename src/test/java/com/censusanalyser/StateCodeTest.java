package com.censusanalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StateCodeTest {
	private StateCensusAnalyser stateCensusAnalyser;
	public static final String STATE_CODE_FILE_PATH = "./IndiaStateCode.csv";
	

	@Before
	public void initialize() {
		stateCensusAnalyser = new StateCensusAnalyser();

	}

	@Test
	public void givenStateCodeCSVFile_ShouldReturnNumberOfRecords() throws CensusAnalyserException  {
		int numOfEntries = stateCensusAnalyser.loadIndiaStateCodeData(STATE_CODE_FILE_PATH);
		Assert.assertEquals(37, numOfEntries);
	}
	
	
}
