CREATE TABLE users_informations(
    id SERIAL PRIMARY KEY ,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL ,
    adress VARCHAR(255) NOT NULL ,
    city VARCHAR(255) NOT NULL ,
    postal_code VARCHAR(50) NOT NULL ,
    telephone_number VARCHAR(9) NOT NULL,
    gender VARCHAR(255) NOT NULL
);

CREATE TABLE users(
                      id SERIAL PRIMARY KEY ,
                      pesel VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL ,
                      email VARCHAR(255) UNIQUE NOT NULL ,
                      created_date DATE NOT NULL ,
                      updated_date DATE
);

ALTER TABLE users add user_information_id INT UNIQUE,
    ADD FOREIGN KEY (user_information_id) REFERENCES users_informations(id) ON UPDATE CASCADE