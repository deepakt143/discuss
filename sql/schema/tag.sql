CREATE TABLE tag (
    tag_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    discription VARCHAR(100),
    popularity INT DEFAULT(0),
    CONSTRAINT tag_pk PRIMARY KEY (tag_id)
);
CREATE INDEX tag_pk_idx ON tag USING hash(tag_id);
