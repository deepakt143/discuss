CREATE TABLE person_tag_interests (
    person_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT person_tag_interests_pk PRIMARY KEY (tag_id, person_id),
    CONSTRAINT person_tag_interests_person_id_fk FOREIGN KEY (person_id) REFERENCES person(person_id) ON DELETE CASCADE,
    CONSTRAINT person_tag_interests_tag_id_fk FOREIGN KEY (tag_id) REFERENCES tag(tag_id) On DELETE CASCADE
);
CREATE INDEX person_tag_interests_person_id_idx on person_tag_interests USING hash(person_id);
CREATE INDEX person_tag_interests_tag_id_idx on person_tag_interests USING hash(tag_id);
