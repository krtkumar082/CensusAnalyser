package com.censusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
		if (!csvFilePath.contains(".csv")) {
			throw new CensusAnalyserException("Not CSV file",
					CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE);
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException("File not found",
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException("File data not proper",
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);

		}
	}
    
	public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
		if (!csvFilePath.contains(".csv")) {
			throw new CensusAnalyserException("Not CSV file",
					CensusAnalyserException.ExceptionType.INCORRECT_FILE_TYPE);
		}
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			Iterable<CSVStateCensus> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException("File not found",
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException("File data not proper",
					CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);

		}
	}
	
}

