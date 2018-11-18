package com.myweather.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id_stacji",
"stacja",
"data_pomiaru",
"godzina_pomiaru",
"temperatura",
"predkosc_wiatru",
"kierunek_wiatru",
"wilgotnosc_wzgledna",
"suma_opadu",
"cisnienie"
})

@Entity
@Table(name="history")
public class WeatherObject {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
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
@Transient
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


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
public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}
public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}



}
