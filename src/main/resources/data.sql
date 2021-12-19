REPLACE INTO roles VALUES (1,'ADMIN');
REPLACE INTO roles VALUES (2,'DOCTOR');
REPLACE INTO roles VALUES (3,'PATIENT');
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (1, 'admin@admin', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Admin', 'Admin', 'Admin', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (1, 1);

REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (2, 'test1@test', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Test', 'Test', 'Test1', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (2, 3);
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (3, 'test2@test', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Test', 'Test', 'Test', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (3, 3);
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (4, 'test3@test', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Test', 'Test', 'Test', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (4, 3);
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (5, 'test4@test', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Test', 'Test', 'Test', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (5, 3);

REPLACE INTO doctor(id, experience, user_id) VALUES (1, 10, 1);
