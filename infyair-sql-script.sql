drop schema infyair;
create schema infyair;

use infyair;

drop table customer;
drop table flight;
drop table booking;
drop table payment;
drop table passenger;
drop table booking_passenger;

create table customer(
id integer auto_increment primary key,
first_name varchar(50),
last_name varchar(50),
age integer,
gender char,
city varchar(50),
mobile varchar(13),
email varchar(50),
pass varchar(50),
token varchar(32));

create table flight(
id integer auto_increment primary key,
company varchar(50),
flight_number varchar(50),
doj timestamp,
source varchar(50),
destination varchar(50),
duration integer,
price integer,
pnr varchar(6),
available_seat varchar(32));

create table payment(
id integer auto_increment primary key,
booking_id integer NOT NULL references booking(id),
amount integer);

create table booking(
id integer auto_increment primary key,
flight_id integer NOT NULL,
customer_id integer NOT NULL,
payment_id integer NULL,
booking_time timestamp,
number_of_seat integer,
CONSTRAINT fk_booking_flight FOREIGN KEY (flight_id) REFERENCES flight(id),
CONSTRAINT fk_booking_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
CONSTRAINT fk_booking_payment FOREIGN KEY (payment_id) REFERENCES payment(id));

create table passenger(
id integer auto_increment primary key,
customer_id integer NOT NULL references customer(id),
first_name varchar(50),
last_name varchar(50),
age integer,
gender char,
mobile varchar(50),
CONSTRAINT fk_passenger_customer FOREIGN KEY (customer_id) REFERENCES customer(id));

create table booking_passenger(
booking_id integer NOT NULL references booking(id),
passenger_id integer NOT NULL references passenger(id),
meal_type varchar(10),
CONSTRAINT fk_booking FOREIGN KEY (booking_id) REFERENCES booking(id),
CONSTRAINT fk_passenger FOREIGN KEY (passenger_id) REFERENCES passenger(id));

alter table payment add CONSTRAINT fk_payment_booking FOREIGN KEY (booking_id) REFERENCES booking(id);
commit;