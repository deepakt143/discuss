CREATE TABLE question (
    question_id INT NOT NULL,
    upvotes INT DEFAULT(0),
    views INT DEFAULT(0),
    difficulty INT DEFAULT(0),
    timestamp TIMESTAMP NOT NULL,
    text VARCHAR,
    image_id INT,
    CONSTRAINT question_pk PRIMARY KEY (question_id)
);
CREATE INDEX question_pk_idx ON question USING hash(question_id);
