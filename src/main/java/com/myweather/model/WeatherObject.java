package com.myweather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "History")
public class WeatherObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty("id_stacji")
	private String stationId;
	
	@JsonProperty("stacja")
	private String stationName;
	
	@JsonProperty("data_pomiaru")
	private String dateOfMeasurement;
	
	@JsonProperty("godzina_pomiaru")
	private String timeOfMeasurement;
	
	@JsonProperty("temperatura")
	private String temperature;
	
	@JsonProperty("predkosc_wiatru")
	private String windSpeed;
	
	@JsonProperty("kierunek_wiatru")
	private String windDirection;
	
	@JsonProperty("wilgotnosc_wzgledna")
	private String humidity;
	
	@JsonProperty("suma_opadu")
	private String precipitationSummary;
	
	@JsonProperty("cisnienie")
	private String pressure;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getDateOfMeasurement() {
		return dateOfMeasurement;
	}

	public void setDateOfMeasurement(String dateOfMeasurement) {
		this.dateOfMeasurement = dateOfMeasurement;
	}

	public String getTimeOfMeasurement() {
		return timeOfMeasurement;
	}

	public void setTimeOfMeasurement(String timeOfMeasurement) {
		this.timeOfMeasurement = timeOfMeasurement;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPrecipitationSummary() {
		return precipitationSummary;
	}

	public void setPrecipitationSummary(String precipitationSummary) {
		this.precipitationSummary = precipitationSummary;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return "WeatherObject [id=" + id + ", stationId=" + stationId + ", stationName=" + stationName
				+ ", dateOfMeasurement=" + dateOfMeasurement + ", timeOfMeasurement=" + timeOfMeasurement
				+ ", temperature=" + temperature + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection
				+ ", humidity=" + humidity + ", precipitationSummary=" + precipitationSummary + ", pressure=" + pressure
				+ "]";
	}

}
