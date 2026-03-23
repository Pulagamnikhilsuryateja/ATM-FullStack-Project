CREATE DATABASE DataBase_Name;
USE DataBase_Name;

CREATE TABLE atm_users (
    acc_no BIGINT PRIMARY KEY,
    name VARCHAR(50),
    pin INT,
    balance DOUBLE,
    type VARCHAR(20)
);

-- Sample Data
INSERT INTO atm_users VALUES
(123456789012, 'Nikhil', 1234, 5000, 'savings');