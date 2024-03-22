CREATE DATABASE gestione_laboratorio;

USE gestione_laboratorio;

CREATE TABLE manutenzione (
 id INT NOT NULL AUTO_INCREMENT,
 data_intervento DATE NOT NULL,
 descrizione VARCHAR(255) NOT NULL,
 tecnico VARCHAR(50) NOT NULL,
 PRIMARY KEY (id)
);
