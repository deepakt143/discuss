CREATE TABLE person_question_bookmarks (
    person_id INT NOT NULL,
    question_id INT NOT NULL ,
    CONSTRAINT person_question_bookmarks_pk PRIMARY KEY (question_id, person_id),
    CONSTRAINT person_question_bookmarks_person_id_fk FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE,
    CONSTRAINT person_question_bookmarks_question_id_fk FOREIGN KEY (question_id) REFERENCES question(question_id) On DELETE CASCADE
);
CREATE INDEX person_question_bookmarks_person_id_idx on person_question_bookmarks USING hash(person_id);
