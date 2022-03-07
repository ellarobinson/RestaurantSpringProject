drop table if exists customer;
create table customer (
customer_id integer auto_increment, 
address varchar(255), 
age integer not null, 
email varchar(255), 
name varchar(255), 
num_of_visits integer not null, 
phone varchar(255), 
primary key (customer_id)
);