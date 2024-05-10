-- Create database structure

CREATE DATABASE presence_senai_db;

USE presence_senai_db;

CREATE TABLE presence_table (
	id INT AUTO_INCREMENT,
    name VARCHAR(255), 
	date_birth DATE, 
    email VARCHAR(255), 
	professional_goal VARCHAR(255),
    neighborhood VARCHAR(255),
    CONSTRAINT pk_presence_table PRIMARY KEY (id)
);

-- insert datas

INSERT INTO presence_table VALUES
(default, "Felipe de França Vieira", "2006-02-25", "felipefrancavieira5@gmail.com", "Full-Stack Developer DevOps", "Grajaú"),
(default, "Luccas Correa", "1998-10-12", "luccascorrea@gmail.com", "Front-End Developer", "Capão Redondo"),
(default, "Arthur Medeiros", "2004-04-12", "arthurmedeiros@gmail.com", "Full-Stack Developer", "Taboão"),
(default, "Alexsander Bittencourt", "2001-03-20", "alexsanderbittencourt@gmail.com", "Mobile Developer", "Parelheiros"),
(default, "Roberto Chile", "2005-01-20", "robertochile@gmail.com", "Cyber Security Analist", "Embu-Guaçu"),
(default, "Alexandre Vieira", "2003-05-10", "alexandrevieira@gmail.com", "Data Engineer", "Ilha Do Bororé"),
(default, "Atila Olivi", "2000-08-19", "atilaolivi@gmail.com", "Software Engineer", "Alphaville");
