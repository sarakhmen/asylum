REPLACE INTO roles VALUES (1,'ADMIN');
REPLACE INTO roles VALUES (2,'DOCTOR');
REPLACE INTO roles VALUES (3,'PATIENT');
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
    VALUES (1, 'admin@admin', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'Admin', 'Admin', 'Admin', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (1, 1);