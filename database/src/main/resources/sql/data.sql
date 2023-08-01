INSERT INTO roles(role)
VALUES ('Administrator'),
('Sale User'),
('Customer User'),
('Secure API User');

INSERT INTO users(role_id, email, last_name, name, mid_name)
VALUES (1, 'maxik@gmail.com', 'White', 'Max', 'Konstantinovich'),
       (2, 'katya@gmail.com', 'Yarmosh', 'Kate', 'Ivanovna'),
       (3, 'ivan@gmail.com', 'Ivanov', 'Ivan', 'Maximovich'),
       (4, 'bogdan@gmail.com', 'Kyzmich', 'Bogdan', 'Ruslanovich'),
       (1, 'tarama@gmail.com', 'Pavlovskya', 'Tamara', 'Pertrovna'),
       (2, 'pert@gmail.com', 'Spodaba', 'Petr', 'Michailovich'),
       (3, 'nikola@gmail.com', 'Novik', 'Nikolay', 'Vladivirovich'),
       (4, 'alexey@gmail.com', 'Axel', 'Alexey', 'Grodmate'),
       (1, 'irisha@gmail.com', 'Krish', 'Irina', 'Ivanovna'),
       (2, 'alesia@gmail.com', 'Kastyk', 'Alesia', 'Maximovna'),
       (3, 'anna@gmail.com', 'Argon', 'Anna', 'Sergeevna'),
       (4, 'dmitry@gmail.com', 'Karasyk', 'Dmitriy', 'Viktorovich'),
       (1, 'elena@gmail.com', 'Alyish', 'Elena', 'Emptovna');