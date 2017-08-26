CREATE TABLE question (
    question_id INT NOT NULL,
    likes INT DEFAULT(0),
    views INT DEFAULT(0),
    rating INT DEFAULT(0),
    text VARCHAR,
    image_id VARCHAR,
    CONSTRAINT question_pk PRIMARY KEY (question_id)
);
CREATE INDEX question_pk_idx ON question USING hash(question_id);
