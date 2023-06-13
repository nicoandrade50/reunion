CREATE TABLE IF NOT EXISTS conference (

  id SERIAL,
  title VARCHAR(30) NOT NULL,
  description VARCHAR(100) NOT NULL,
  assistants INT NOT NULL,
    PRIMARY KEY (id)
);