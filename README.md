# MyWeather
> This is a web application presenting the current weather in 62 Polish cities.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [License](#license)

## General info
The data is obtained through the IMGW API interface in JSON format.
You can go to the search page as a guest or after logging in as a user,admin. 
After logging as a user, you get access to the history of your searches, which is saved in the database.
After logging in as an administrator, you can view your history as well as the history of all users.
During the start of the application, tables are created in a specific database with three users and three access roles.

 Users:
 * guest (GUEST access role), username guest, password guest
 * user (USER access role), username user, password user
 * admin (ADMIN access role), username admin, password admin
 
 


## Technologies
   * Java 8
   * Spring 5
   * Spring Security 5
   * Hibernate 5
   * Maven
   * Jackson 2.9.7
   * JSTL 1.2
   * c3p0 0.9.5.2

## Setup

## Features
 To-do list:
  * adding unit and integration tests
  * changing the strategy of downloading data from EAGER to LAZY and removing the error related to this
  * improving the visual presentation of pages
  * adding a REST API to share user search history
  * adding options for editing user data by people with ADMIN roles

## Status
Project is: in progress

## License
   * EN "The source of data is the Institute of Meteorology and Water Management - National Research Institute".
   * PL „Źródłem pochodzenia danych jest Instytut Meteorologii i Gospodarki Wodnej – Państwowy Instytut Badawczy”.
