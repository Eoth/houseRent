-- supprimer les éléments des tables
--DELETE FROM PRODUCT;
--DELETE FROM USER;
--DELETE FROM RESERVATION;

-- supprimer les tables
--DROP TABLE IF EXISTS PRODUCT
--DROP TABLE IF EXISTS USER
--DROP TABLE IF EXISTS RESERVATION

--recréer les tales
--create table product (product_id integer not null, adress varchar(255) not null, available boolean not null, begin_date timestamp not null, end_date timestamp not null, nb_pers integer not null, price double not null, type_property varchar(255) not null, owner_user_id integer, renter_user_id integer, res_res_id integer, primary key (product_id));
--create table reservation (res_id integer not null, primary key (res_id));
--create table user (user_id integer not null, first_name varchar(255), last_name varchar(255), password varchar(255), role varchar(255), username varchar(255), user_res_res_id integer, primary key (user_id));
--alter table product add constraint FKph6i0wdfd37itngda05wy6trr foreign key (owner_user_id) references user;
--alter table product add constraint FKhl19w8ikvb1pd82elxlhjqxqq foreign key (renter_user_id) references user;
--alter table product add constraint FK2y0u46vlwkp77wo4oite2q8b4 foreign key (res_res_id) references reservation;
--alter table user add constraint FKraq0k7vlnuhci2s8t4g6k1slh foreign key (user_res_res_id) references reservation;
--alter table user add constraint FK388j0vyq4hnj72xl53tdls2u4 foreign key (user_id) references user;

-- supprimer les éléments des tables
DELETE FROM PRODUCT;
DELETE FROM USER;
DELETE FROM RESERVATION;

-- insertion des données utilisateurs
INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(1,'Tibé','NAKOTE','admin', 'ADMIN', 'admin',null);
INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(2,'Romaric','DOUMENC','user', 'USER', 'user',null); 
INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(3,'Olivier','DJIKEUDJIE','user1', 'USER', 'user1',null);

-- insertions des données des maisons
INSERT INTO PRODUCT(PRODUCT_ID , ADRESS , AVAILABLE, BEGIN_DATE, END_DATE, NB_PERS, PRICE,  TYPE_PROPERTY, OWNER_USER_ID, RENTER_USER_ID, RES_RES_ID ) VALUES (1,'1 rue des marches', TRUE , '2019-12-06', '2020-12-06', 3, 450, 'MAISON', 1, null, 	null);
INSERT INTO PRODUCT(PRODUCT_ID , ADRESS , AVAILABLE, BEGIN_DATE, END_DATE, NB_PERS, PRICE,  TYPE_PROPERTY, OWNER_USER_ID, RENTER_USER_ID, RES_RES_ID ) VALUES (2,'1 rue de note 20/20', TRUE , '2019-12-06', '2020-12-06', 5, 600, 'VILLA', 1, null, 	null);


