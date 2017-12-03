CREATE TABLE person_question_likes (
    person_id INT NOT NULL,
    question_id INT NOT NULL,
    CONSTRAINT person_question_likes_pk PRIMARY KEY (question_id, person_id),
    CONSTRAINT person_question_likes_person_id_fk FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE,
    CONSTRAINT person_question_likes_question_id_fk FOREIGN KEY (question_id) REFERENCES question(question_id) On DELETE CASCADE
);
CREATE INDEX person_question_likes_person_id_idx on person_question_likes USING hash(person_id);
CREATE INDEX person_question_likes_question_id_idx on person_question_likes USING hash(question_id);
