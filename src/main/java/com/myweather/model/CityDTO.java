package com.myweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityDTO {
	
	@JsonProperty("id_stacji")
	private String stationId;
	
	@JsonProperty("stacja")
	private String stationName;

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return "CityName [stationId=" + stationId + ", stationName=" + stationName + "]";
	}
	
}
