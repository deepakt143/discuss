CREATE TABLE comment (
    comment_id INT NOT NULL,
    likes INT DEFAULT(0),
    views INT DEFAULT(0),
    upvotes INT DEFAULT(0),
    timestamp TIMESTAMP NOT NULL,
    text VARCHAR,
    image_id VARCHAR,
    question_id INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT comment_pk PRIMARY KEY(comment_id),
    CONSTRAINT comment_user_id_fk FOREIGN KEY(user_id) REFERENCES user(user_id),
    CONSTRAINT comment_question_id_fk FOREIGN KEY(question_id) REFERENCES question(question_id) ON DELETE CASCADE
);
CREATE INDEX comment_question_pk_idx on comment USING hash(comment_id, question_id);
CREATE INDEX comment_comment_id_idx on comment USING hash(comment_id);
CREATE INDEX comment_question_id_idx on comment USING hash(question_id);
