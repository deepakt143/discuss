CREATE TABLE question_tag (
    question_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT question_tag_pk PRIMARY KEY(question_id, tag_id),
    CONSTRAINT question_tag_question_id_fk FOREIGN KEY(question_id) REFERENCES question(question_id),
    CONSTRAINT question_tag_tag_id_fk FOREIGN KEY(tag_id) REFERENCES tag(tag_id)
);
CREATE INDEX question_tag_tag_id_idx on comment USING hash(tag_id);
