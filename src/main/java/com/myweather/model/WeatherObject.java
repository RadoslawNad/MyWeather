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
	private int stationId;

	@JsonProperty("stacja")
	private String stationName;

	@JsonProperty("data_pomiaru")
	private String dateOfMeasurement;

	@JsonProperty("godzina_pomiaru")
	private int timeOfMeasurement;

	@JsonProperty("temperatura")
	private float temperature;

	@JsonProperty("predkosc_wiatru")
	private float windSpeed;

	@JsonProperty("kierunek_wiatru")
	private String windDirection;

	@JsonProperty("wilgotnosc_wzgledna")
	private float humidity;

	@JsonProperty("suma_opadu")
	private float precipitationSummary;

	@JsonProperty("cisnienie")
	private float pressure;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
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

	public int getTimeOfMeasurement() {
		return timeOfMeasurement;
	}

	public void setTimeOfMeasurement(int timeOfMeasurement) {
		this.timeOfMeasurement = timeOfMeasurement;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getPrecipitationSummary() {
		return precipitationSummary;
	}

	public void setPrecipitationSummary(float precipitationSummary) {
		this.precipitationSummary = precipitationSummary;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
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
