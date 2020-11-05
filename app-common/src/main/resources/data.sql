DROP TABLE IF EXISTS OPERATION_SCHEDULE;

CREATE TABLE OPERATION_SCHEDULE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  SCHEDULE DATE,
  IS_OPEN BOOLEAN
);

INSERT INTO OPERATION_SCHEDULE (SCHEDULE, IS_OPEN) VALUES (CURRENT_TIMESTAMP, TRUE);

--DROP TABLE IF EXISTS billionaires;
--
--	CREATE TABLE billionaires (
--	  id INT AUTO_INCREMENT  PRIMARY KEY,
--	  first_name VARCHAR(250) NOT NULL,
--	  last_name VARCHAR(250) NOT NULL,
--	  career VARCHAR(250) DEFAULT NULL
--	);
--
--	INSERT INTO billionaires (first_name, last_name, career) VALUES
--	  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
--	  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
--	  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');