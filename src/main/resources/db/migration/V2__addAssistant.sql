CREATE TABLE IF NOT EXISTS assistant (
id SERIAL,
fullname VARCHAR(30) NOT NULL,
rol VARCHAR(20),
age INT NOT NULL,
conference_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (conference_id) REFERENCES conference (id)

);