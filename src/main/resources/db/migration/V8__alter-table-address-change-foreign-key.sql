ALTER TABLE address DROP CONSTRAINT fk_user;
ALTER TABLE address DROP COLUMN user_id;


ALTER TABLE address ADD COLUMN client_id BIGINT NOT NULL;

ALTER TABLE address
ADD CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES clients(id);