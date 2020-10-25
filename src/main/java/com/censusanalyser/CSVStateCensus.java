package com.censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column = "State", required = true)
	public String state;
	
	@CsvBindByName(column = "Population", required = true)
	public String population;
	
	@CsvBindByName(column = "AreaInSqKm", required = true)
	public String areaInSqKm;
	
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	public String densityPerSqKm;
	public CSVStateCensus() {
	}

	public CSVStateCensus(String state, String population, String areaInSqKm, String densityPerSqKm) {
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	@Override
	public String toString() {
		return "CSVStateCensus{" + "State='" + state + '\'' + ", Population='" + population + '\'' + ", AreaInSqKm='"
				+ areaInSqKm + '\'' + ", DensityPerSqKm='" + densityPerSqKm + '\'' + '}';
	}
}
