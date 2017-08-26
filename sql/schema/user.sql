CREATE TABLE user (
    user_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    rating INT DEFAULT(0),
    points INT DEFAULT(0),
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);
CREATE INDEX user_pk_idx ON user USING hash(user_id);
