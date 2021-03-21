insert into user (username, password, first_name, surname, role) values ('user1', 'password', 'Pepa', 'Vomacka', 'USER');
insert into user (username, password, first_name, surname, role) values ('user2', 'password', 'Jakub', 'Novák', 'USER');
insert into user (username, password, first_name, surname, role) values ('clerk1', 'password', 'Honza', 'Richter', 'CLERK');
insert into user (username, password, first_name, surname, role) values ('admin1', 'password', 'Jiri', 'Briza', 'ADMIN');

insert into court (active, name, type) values (1, 'Center', 'TENNIS_DOUBLES');
insert into court (active, name, type) values (1, 'Kurt 1', 'TENNIS_SINGLES');

insert into reservation (confirmed, user_id) values (1, 1);
insert into reservation (confirmed, user_id) values (1, 2);
insert into reservation (confirmed, user_id) values (1, 1);

insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 14:00:00', '2021-4-20 14:30:00',1, 1);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 14:00:00', '2021-4-20 14:30:00',2, 2);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 14:30:00', '2021-4-20 15:00:00',1, 1);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 14:30:00', '2021-4-20 14:50:00',2, 2);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 15:00:00', '2021-4-20 15:30:00',1, null);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 15:00:00', '2021-4-20 15:30:00',2, null);
insert into training_unit (time_from, time_to, court_id, reservation_id) values ('2021-4-20 15:30:00', '2021-4-20 14:30:00',1, 1);

