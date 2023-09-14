insert into users (name, username, password)
values ('Dmitro Kyiashchenko', 'dkey', '$2a$10$IcG6xUap.VYmcFwBdvfYNOPjtk5N2H535BNrvrCgRc/Pu3ZgtD5KS'),
('Vasil Vasiliev', 'vasia', '$2a$10$sqDGyK9l9daxUoP5FB2speQs5cWTXIGOr4ZDJ2nPT.Jw8s7LqD4lK');

insert into tasks (title, description, status, expiration_date)
values ('Buy beer', null, 'TODO', '2023-01-01'),
('Clean room', 'In my house', 'IN_PROGRESS', '2023-03-03'),
('Send letter', 'Say about my ideas', 'DONE', '2023-05-05'),
('Make a notes about meeting', 'For report of my business trip','TODO', '2023-09-02');

insert into users_tasks (task_id, user_id)
values(1,2), (2,2), (3,2), (4,1);

insert into users_roles (user_id, role)
values(1,'ROLE_ADMIN'), (1,'ROLE_USER'), (2,'ROLE_USER');

