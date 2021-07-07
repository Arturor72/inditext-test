DROP TABLE IF EXISTS meteorological_data;

CREATE TABLE meteorological_data (
  id BIGINT  PRIMARY KEY,
  date DATE NOT NULL,
  temperature VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS location;

CREATE TABLE location (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_met_data BIGINT,
  lat DECIMAL(24,4) NOT NULL,
  lon DECIMAL(24,4) NOT NULL,
  city VARCHAR(25) NOT NULL,
  state VARCHAR(25) NOT NULL,
  foreign key (id_met_data) references meteorological_data(id)
);

INSERT INTO meteorological_data (id, date, temperature) VALUES
  (121,'2021-07-06', '23.5|34.5'),
  (122,'2021-07-07', '23.5|34.5'),
  (123,'2021-07-08', '23.5|34.5'),
  (124,'2021-07-09', '23.5|34.5'),
  (125,'2021-07-10', '23.5|34.5');

 INSERT INTO location (id_met_data, lat, lon, city, state) VALUES
   (121, 123.44, 2323.45, 'Babylon', 'New York'),
   (122, 123.44, 2323.45, 'Clinton', 'New York'),
   (123, 123.44, 2323.45, 'Bath', 'North Carolina'),
   (124, 123.44, 2323.45, 'Bismark', 'North Dacota'),
   (125, 123.44, 2323.45, 'Bedford', 'Ohio');
