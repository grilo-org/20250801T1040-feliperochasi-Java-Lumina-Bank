CREATE TABLE accounts (
    id BIGSERIAL PRIMARY KEY,
    number VARCHAR(100) NOT NULL,
    digit VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    plan VARCHAR(100) NOT NULL,
    aproved SMALLINT,
    active SMALLINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    client_id BIGINT NOT NULL,

    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients(id)
);