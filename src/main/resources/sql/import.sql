--create table product (product_id integer not null, adress varchar(255) not null, available boolean not null, begin_date timestamp not null, end_date timestamp not null, nb_pers integer not null, price double not null, type_property varchar(255) not null, owner_user_id integer, renter_user_id integer, res_res_id integer, primary key (product_id))
--create table user (user_id integer not null, first_name varchar(255), last_name varchar(255), password varchar(255), role varchar(255), username varchar(255), user_res_res_id integer, primary key (user_id))

INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(1,'Tibé','Nakote','admin', 'ADMIN', 'admin',null)
INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(2,'Romaric','Doumenc','user', 'USER', 'user',null)  
INSERT INTO user (user_id,first_name,last_name,password,role,username,user_res_res_id) VALUES(3,'Olivier','DJIKEUDJIE','user1', 'USER', 'user1',null)