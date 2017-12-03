CREATE TABLE person (
    person_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    points INT DEFAULT(0),
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);
CREATE INDEX person_pk_idx ON person USING hash(person_id);
