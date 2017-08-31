CREATE TABLE user_tag_interests (
    user_id INT NOT NULL,
    tag_id INT NOT NULL,
    CONSTRAINT user_tag_interests_pk PRIMARY KEY (tag_id, user_id),
    CONSTRAINT user_tag_interests_user_id_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT user_tag_interests_tag_id_fk FOREIGN KEY (tag_id) REFERENCES tag(tag_id) On DELETE CASCADE,
);
CREATE INDEX user_tag_interests_user_id_idx on user_tag_likes USING hash(user_id);
CREATE INDEX user_tag_interests_tag_id_idx on user_tag_likes USING hash(tag_id);
