-- Genres

INSERT INTO genre (genre_name) VALUES ('Punk'); -- 1
INSERT INTO genre (genre_name) VALUES ('Indie Rock'); -- 2
INSERT INTO genre (genre_name) VALUES ('Hardcore'); -- 3
INSERT INTO genre (genre_name) VALUES ('New Wave'); -- 4
INSERT INTO genre (genre_name) VALUES ('Industrial'); -- 5
INSERT INTO genre (genre_name) VALUES ('Post-Hardcore'); -- 6 
INSERT INTO genre (genre_name) VALUES ('Pop'); -- 7
INSERT INTO genre (genre_name) VALUES ('Shoegaze'); -- 8
INSERT INTO genre (genre_name) VALUES ('Dream Pop'); -- 9
INSERT INTO genre (genre_name) VALUES ('Emo'); -- 10
INSERT INTO genre (genre_name) VALUES ('Screamo'); -- 11
INSERT INTO genre (genre_name) VALUES ('Electro'); -- 12
INSERT INTO genre (genre_name) VALUES ('IDM'); -- 13
INSERT INTO genre (genre_name) VALUES ('House'); -- 14
INSERT INTO genre (genre_name) VALUES ('Rap'); -- 15
INSERT INTO genre (genre_name) VALUES ('Goth'); -- 16
INSERT INTO genre (genre_name) VALUES ('Ska'); -- 17
INSERT INTO genre (genre_name) VALUES ('Surf Rock'); -- 18
INSERT INTO genre (genre_name) VALUES ('Indie Pop'); -- 19

-- No Thanks

INSERT INTO city (city_name, state_name) VALUES ('Omaha', 'Nebraska');

INSERT INTO band (band_name, year_started) VALUES ('No Thanks', 2016);


-- Plack Blague

INSERT INTO city (city_name, state_name) VALUES ('Lincoln', 'Nebraska');

INSERT INTO band (band_name, year_started, next_show_date) VALUES ('Plack Blague', 2012, '2023-09-09');


-- Mad Dog & The 20/20s

INSERT INTO city (city_name, state_name) VALUES ('Kearney', 'Nebraska');

INSERT INTO band (band_name, year_started, next_show_date) VALUES ('Mad Dog & The 20/20s', 2015, '2023-04-08');


-- Astrobrite

INSERT INTO city (city_name, state_name) VALUES ('Chicago', 'Illinois');

INSERT INTO band (band_name, year_started, next_show_date) VALUES ('Astrobrite', 1995, '2023-05-19');

-- BIB

INSERT INTO band (band_name, year_started, next_show_date) VALUES ( 'BIB', 2015, '2023-05-08');

-- Talent Show
INSERT INTO band (band_name, year_started, next_show_date) VALUES ('Talent Show', 2018, '2023-12-09');

-- Venues

INSERT INTO venue (venue_name) VALUES ('Reverb Lounge');
INSERT INTO venue (venue_name) VALUES ('The Waiting Room');
INSERT INTO venue (venue_name) VALUES ('The Slowdown');
INSERT INTO venue (venue_name) VALUES ('The Admiral');
INSERT INTO venue (venue_name) VALUES ('The Sydney');
INSERT INTO venue (venue_name) VALUES ('The Bourbon Theater');
INSERT INTO venue (venue_name) VALUES ('The Zoo Bar');
INSERT INTO venue (venue_name) VALUES ('Duffys');
INSERT INTO venue (venue_name) VALUES ('Gillies');
INSERT INTO venue (venue_name) VALUES ('The Hideout');
INSERT INTO venue (venue_name) VALUES ('Coles');
INSERT INTO venue (venue_name) VALUES ('The Music Box');

-- Albums
INSERT INTO album (band_fk, album_name) VALUES (1, 'The Harvest');
INSERT INTO album (band_fk, album_name) VALUES (1, 'Submerger');
INSERT INTO album (band_fk, album_name) VALUES (2, 'Untitled');
INSERT INTO album (band_fk, album_name) VALUES (3, 'Things We Should Have Said');
INSERT INTO album (band_fk, album_name) VALUES (3, 'Mad Dog and the 20/20s');
INSERT INTO album (band_fk, album_name) VALUES (4, 'super crush');
INSERT INTO album (band_fk, album_name) VALUES (4, 'pinkshinyultrablast');
INSERT INTO album (band_fk, album_name) VALUES (4, 'Crush');
INSERT INTO album (band_fk, album_name) VALUES (5, 'Delux');
INSERT INTO album (band_fk, album_name) VALUES (5, 'Moshpit');
INSERT INTO album (band_fk, album_name) VALUES (6, 'Provider');
-- Test Show

INSERT INTO shows (band_fk, city_fk, venue_fk) VALUES (6, 1, 3);

INSERT INTO shows_genre (show_fk, genre_fk) VALUES (1, 2);
INSERT INTO shows_genre (show_fk, genre_fk) VALUES (1, 18);
INSERT INTO shows_genre (show_fk, genre_fk) VALUES (1, 19);