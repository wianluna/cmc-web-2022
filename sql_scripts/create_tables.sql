SET DATESTYLE TO "DMY";

DROP TABLE IF EXISTS Physical_Properties;
DROP TABLE IF EXISTS Specimens_Composition;
DROP TABLE IF EXISTS Mineral_Specimens;
DROP TABLE IF EXISTS Expeditions;
DROP TABLE IF EXISTS Mineral_Species;
DROP TABLE IF EXISTS Classification;

CREATE TABLE Classification (
    class_id SERIAL,
    type text,
    class text,
    subclass text,
    PRIMARY KEY (class_id)
);

CREATE TABLE Mineral_Species (
    species_id SERIAL,
    species_name text NOT NULL,
    chemical_formula text DEFAULT NULL,
    origin text DEFAULT NULL, -- осадочное, вулканическое, метаморфическое
    class_id integer REFERENCES Classification ON DELETE SET NULL ON UPDATE CASCADE,
    PRIMARY KEY (species_id)
);

CREATE TABLE Physical_Properties (
    species_id integer REFERENCES Mineral_Species ON DELETE CASCADE ON UPDATE CASCADE,
    lattice_type text NOT NULL,
    hardness float NOT NULL,
    lustre text NOT NULL,
    color text NOT NULL,
    magnetism text NOT NULL,
    PRIMARY KEY (species_id)
);

CREATE TABLE Expeditions (
    expedition_id SERIAL,
    date_start timestamp,
    date_end timestamp,
    members text,
    description text,
    PRIMARY KEY (expedition_id)
);

CREATE TABLE Mineral_Specimens (
    specimen_id SERIAL,
    possible_origin text DEFAULT NULL,
    location text,
    coordinates text,
    source text,
    expedition_id integer REFERENCES Expeditions ON DELETE RESTRICT,
    PRIMARY KEY (specimen_id)
);

CREATE TABLE Specimens_Composition (
    specimen_id integer NOT NULL references Mineral_Specimens ON DELETE CASCADE,
    species_id integer NOT NULL references Mineral_Species ON DELETE CASCADE,
    species_name text NOT NULL,
    inclusion_type text,
    percentage float,
    PRIMARY KEY (specimen_id, species_id)
);
