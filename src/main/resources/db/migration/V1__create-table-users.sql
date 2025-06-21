CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(20),
    uf VARCHAR(2) NOT NULL,
    city VARCHAR(100) NOT NULL
);