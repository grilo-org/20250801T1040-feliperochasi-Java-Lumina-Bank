CREATE TABLE address (
    address VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(20),
    uf VARCHAR(2) NOT NULL,
    city VARCHAR(100) NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);