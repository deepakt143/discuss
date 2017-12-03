CREATE TABLE person_comment_likes (
    person_id INT NOT NULL,
    comment_id INT NOT NULL,
    CONSTRAINT person_comment_likes_pk PRIMARY KEY (comment_id, person_id),
    CONSTRAINT person_comment_likes_person_id_fk FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE,
    CONSTRAINT person_comment_likes_comment_id_fk FOREIGN KEY (comment_id) REFERENCES comment(comment_id) On DELETE CASCADE
);
CREATE INDEX person_comment_likes_person_id_idx on person_comment_likes USING hash(person_id);
CREATE INDEX person_comment_likes_comment_id_idx on person_comment_likes USING hash(comment_id);
