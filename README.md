WILDLIFE TRACKER
An application to manage track wildlife

DESCRIPTION
This application is designed to the Forest Service. This application will allow the rangers of the Forest Service to track 
endangered and non-endangered animals for a wildlife study.

SETUP/INSTALLATION REQUIREMENTS
Create the database and tables in PSQL:

CREATE DATABASE wildlife_tracker; 

CREATE TABLE animals (id serial PRIMARY KEY, name varchar NOT NULL UNIQUE, health varchar, age numeric, type varchar NOT NULL); 

CREATE TABLE rangers (id serial PRIMARY KEY, username varchar NOT NULL UNIQUE, firstname varchar NOT NULL, 
lastname varchar NOT NULL, badge int NOT NULL, phone bigint NOT NULL); 

CREATE TABLE locations (id serial PRIMARY KEY, name varchar NOT NULL UNIQUE, x_coord numeric NOT NULL, 
y_coord numeric NOT NULL); 

CREATE TABLE sightings (id serial PRIMARY KEY, time_of_sighting timestamp NOT NULL, 
animal_id int REFERENCES animals (id) ON DELETE CASCADE, location_id int REFERENCES locations (id) ON DELETE CASCADE, 
ranger_id int REFERENCES rangers (id) ON DELETE CASCADE); 

Download Java and build source code from GitHub in the terminal.

git clone https://github.com/stewilondanga/wildlife-tracker.git cd wildlife-tracker 

gradle run Then open http://localhost:4567 in your preferred web browser.

OBJECTIVES
An interface or inherited class provides similar content in different classes. 
Database timestamps are included for each sighting. 
At least two Exceptions can be thrown and caught. 
Constants are used in at least one class. 
Previous standards are met (see below). 
Project demonstrates an understanding of concepts covered this week. 
If prompted, you can discuss your code and concepts behind it with an instructor using the correct terminology. 
Project is in a polished, portfolio-ready state. 
Application works as expected. 
Tests have complete coverage for all behaviors. 
All tests are formatted correctly and pass. 
Logic is easy to understand. 
Build files are discluded from Git using a .gitignore file. 

Code and Git documentation follows best practices (descriptive variables names, proper indentation and spacing, 
separation between front and back-end logic, detailed commit messages in the correct tense, and a well-formatted README). 

MINIMUM SPECIFICATION
The program should be able to store and retrieve the names of each animal. 
Example Input: squirrel 
Example Output: squirrel 

The program should be able to store and retrieve the health of each endangered animal. 
Example Input: panda health is ill 
Example Output: panda health is ill 

The program should be able to store and retrieve the age of each endangered animal. 
Example Input: panda age is newborn 
Example Output: panda age is newborn 

The program should be able to store and retrieve the location where an animal was sighted. 
Example Input: north of bridge 
Example Output: north of bridge 

The program should be able to store and retrieve the name of the ranger who saw the animal 
Example Input: Mjanja 
Example Output: Mjanja 

The program should be able save all of the above to a database. 
Example Input: Save Mjanja 
Example Output: [None] 

The program should be able delete any of the above from the database. 
Example Input: Delete Mjanja 
Example Output: [None] 

TECHNOLOGIES USED
Java 
JUnit 
Gradle 
Spark 
Velocity 
PostgreSQL 
