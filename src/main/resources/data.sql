-- Insert values into EMPLOYEE, ROLE, USER and USERS_ROLES tables
-- USERS_ROLES table is a temporary table created due to the many to many relation between USER and ROLE tables

INSERT INTO EMPLOYEE
VALUES (1, 'akshit.baunthy@gmail.com', 'Akshit', 'Baunthiyal');
INSERT INTO EMPLOYEE
VALUES (2, 'ananya98baunthiyal@gmail.com', 'Ananya', 'Baunthiyal');

INSERT INTO ROLE
VALUES (1, 'ADMIN');
INSERT INTO ROLE
VALUES(2, 'USER');

INSERT INTO USER
VALUES (1, '$2a$12$wLrHcTJUW6BIKxylLNneXezJp5xUlewueLBcy/OfBbyLVM7QB.HEG', 'akshit');
INSERT INTO USER
VALUES(2, '$2a$12$1bjI/nmgK.pLBiZKKE.9yeQYFa3aXzJJRiRYCDWewDaLXtCJikJQC', 'ananya');

INSERT INTO USERS_ROLES
VALUES(1, 1);
INSERT INTO USERS_ROLES
VALUES(2,2);