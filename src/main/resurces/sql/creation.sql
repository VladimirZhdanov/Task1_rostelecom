--create the table:
create table TSVETA(
                       id NUMBER NOT NULL,
                       color_number VARCHAR(2),
                       name VARCHAR(50),
                       PRIMARY KEY(id)
);

--Insert into TSVETA:
insert into TSVETA(id, color_number, name) VALUES (1, '01', 'Red');
insert into TSVETA(id, color_number, name) VALUES (2, '02', 'Orange');
insert into TSVETA(id, color_number, name) VALUES (3, '03', 'Yellow');
insert into TSVETA(id, color_number, name) VALUES (4, '04', 'Green');
insert into TSVETA(id, color_number, name) VALUES (5, '05', 'Blue');
insert into TSVETA(id, color_number, name) VALUES (6, '06', 'Dark blue');
insert into TSVETA(id, color_number, name) VALUES (7, '07', 'Violet');