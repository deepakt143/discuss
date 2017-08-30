CREATE TABLE user_question_likes (
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    CONSTRAINT user_question_likes_pk PRIMARY KEY (question_id, user_id),
    CONSTRAINT user_question_likes_user_id_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT user_question_likes_question_id_fk FOREIGN KEY (question_id) REFERENCES question(question_id) On DELETE CASCADE,
);
CREATE INDEX user_question_likes_user_id_idx on user_question_likes USING hash(user_id);
CREATE INDEX user_question_likes_question_id_idx on user_question_likes USING hash(question_id);
