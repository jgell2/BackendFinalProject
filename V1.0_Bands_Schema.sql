DROP TABLE IF EXISTS shows_genre;
DROP TABLE IF EXISTS shows;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS band;
DROP TABLE IF EXISTS venue;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS city;

CREATE TABLE city (
  city_pk int unsigned NOT NULL AUTO_INCREMENT,
  city_name varchar(50) NOT NULL,
  state_name varchar(50) NOT NULL,
  PRIMARY KEY (city_pk),
  UNIQUE KEY (city_name, state_name)
);

CREATE TABLE genre (
  genre_pk int unsigned NOT NULL AUTO_INCREMENT,
  genre_name varchar(60) UNIQUE NOT NULL,
  PRIMARY KEY (genre_pk),
  UNIQUE KEY (genre_name)
);

CREATE TABLE venue(
  venue_pk int unsigned NOT NULL AUTO_INCREMENT,
  venue_name varchar(60),
  PRIMARY KEY (venue_pk),
  UNIQUE KEY (venue_name)
);

CREATE TABLE band (
  band_pk int unsigned NOT NULL AUTO_INCREMENT,
  band_name varchar(60) NOT NULL,
  year_started YEAR NOT NULL,
  next_show_date DATE,
  PRIMARY KEY (band_pk),
  UNIQUE KEY (band_name)
);

CREATE TABLE album (
  album_pk int unsigned NOT NULL AUTO_INCREMENT,
  band_fk int unsigned NOT NULL,
  album_name varchar(256) NOT NULL,
  PRIMARY KEY (album_pk),
  FOREIGN KEY (band_fk) REFERENCES band (band_pk) ON DELETE CASCADE
);
  
CREATE TABLE shows (
  show_pk int unsigned NOT NULL AUTO_INCREMENT,
  band_fk int unsigned NOT NULL,
  city_fk int unsigned NOT NULL,
  venue_fk int unsigned NOT NULL,
  PRIMARY KEY (show_pk),
  FOREIGN KEY (band_fk) REFERENCES band (band_pk) ON DELETE CASCADE,
  FOREIGN KEY (city_fk) REFERENCES city (city_pk) ON DELETE CASCADE,
  FOREIGN KEY (venue_fk) REFERENCES venue (venue_pk) ON DELETE CASCADE
  );
  
  CREATE TABLE shows_genre (
  show_fk int unsigned NOT NULL,
  genre_fk int unsigned NOT NULL,
  FOREIGN KEY (show_fk) REFERENCES shows (show_pk) ON DELETE CASCADE,
  FOREIGN KEY (genre_fk) REFERENCES genre (genre_pk) ON DELETE CASCADE,
  UNIQUE KEY (show_fk, genre_fk)
);