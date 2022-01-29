CREATE TABLE recipient(
    id SERIAL PRIMARY KEY ,
    added_date DATE NOT NULL
);

ALTER TABLE recipient add user_id INT,
    ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE recipient add bank_account_id INT,
    ADD FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);