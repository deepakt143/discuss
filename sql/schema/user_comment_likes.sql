CREATE TABLE user_comment_likes (
    user_id INT NOT NULL,
    comment_id INT NOT NULL,
    CONSTRAINT user_comment_likes_pk PRIMARY KEY (comment_id, user_id),
    CONSTRAINT user_comment_likes_user_id_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT user_comment_likes_comment_id_fk FOREIGN KEY (comment_id) REFERENCES comment(comment_id) On DELETE CASCADE,
);
CREATE INDEX user_comment_likes_user_id_idx on user_comment_likes USING hash(user_id);
CREATE INDEX user_comment_likes_comment_id_idx on user_comment_likes USING hash(comment_id);
