CREATE TABLE user_question_interests (
    user_id INT NOT NULL,
    question_id INT NOT NULL ,
    CONSTRAINT user_question_interests_pk PRIMARY KEY (question_id, user_id),
    CONSTRAINT user_question_interests_user_id_fk FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,
    CONSTRAINT user_question_interests_question_id_fk FOREIGN KEY (question_id) REFERENCES question(question_id) On DELETE CASCADE,
);
CREATE INDEX user_question_interests_user_id_idx on user_question_interests USING hash(user_id);
