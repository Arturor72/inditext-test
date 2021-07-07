DROP TABLE IF EXISTS meteorological_data;

CREATE TABLE meteorological_data (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  date DATE NOT NULL,
  temperature VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS location;

CREATE TABLE location (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_met_data INT,
  lat DECIMAL(24,4) NOT NULL,
  lon DECIMAL(24,4) NOT NULL,
  city VARCHAR(25) NOT NULL,
  state VARCHAR(25) NOT NULL,
  foreign key (id_met_data) references meteorological_data(id)
);

INSERT INTO meteorological_data (date, temperature) VALUES
  ('2021-07-06', '23.5|34.5'),
  ('2021-07-07', '23.5|34.5'),
  ('2021-07-08', '23.5|34.5'),
  ('2021-07-09', '23.5|34.5'),
  ('2021-07-10', '23.5|34.5');

 INSERT INTO location (id_met_data, lat, lon, city, state) VALUES
   (1, 123.44, 2323.45, 'Babylon', 'New York'),
   (2, 123.44, 2323.45, 'Clinton', 'New York'),
   (3, 123.44, 2323.45, 'Bath', 'North Carolina'),
   (4, 123.44, 2323.45, 'Bismark', 'North Dacota'),
   (5, 123.44, 2323.45, 'Bedford', 'Ohio');
