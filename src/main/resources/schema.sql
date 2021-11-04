CREATE TABLE IF NOT EXISTS USERS (
userId INT PRIMARY KEY auto_increment,
username VARCHAR(20),
salt VARCHAR,
password VARCHAR,
firstname VARCHAR,
lastname VARCHAR
);

CREATE TABLE IF NOT EXISTS MESSAGES (
messageId INT PRIMARY KEY auto_increment,
username VARCHAR NOT NULL,
message VARCHAR NOT NULL
);