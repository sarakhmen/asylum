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
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
VALUES (6, 'doctor1@doctor', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'doctor', 'doctor', 'doctor', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (6, 2);
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
VALUES (7, 'doctor2@doctor', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'doctor', 'doctor', 'doctor', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (7, 2);
REPLACE INTO user(id, email, password, first_name, second_name, patronymic, address, phone, date_of_birth)
VALUES (8, 'doctor3@doctor', '$2a$10$uGtcWDvECRAQABQXW.5h9ewpmKoByySxnLWYzHiVLDebmKvgpcWRW', 'doctor', 'doctor', 'doctor', 'Kyiv', '+380971266262', '2001-09-15');
REPLACE INTO user_role(id, role_id) VALUES (8, 2);

REPLACE INTO diagnose(id, description, name) VALUES (1,'descriprion1', 'diagnos1');
REPLACE INTO diagnose(id, description, name) VALUES (2,'descriprion2', 'diagnos2');
REPLACE INTO diagnose(id, description, name) VALUES (3,'descriprion3', 'diagnos3');

REPLACE INTO department(id, name) VALUES (1, 'department1');
REPLACE INTO department(id, name) VALUES (2, 'department2');
REPLACE INTO department(id, name) VALUES (3, 'department3');

REPLACE INTO asylum.position(id, description, name) VALUES (1, 'position1', 'position1');
REPLACE INTO asylum.position(id, description, name) VALUES (2, 'position2', 'position2');
REPLACE INTO asylum.position(id, description, name) VALUES (3, 'position3', 'position3');

REPLACE INTO doctor(id, experience, department_id, position_id, user_id) VALUES (1, 12, 1, 1, 6);
REPLACE INTO doctor(id, experience, department_id, position_id, user_id) VALUES (2, 23, 2, 2, 7);
REPLACE INTO doctor(id, experience, department_id, position_id, user_id) VALUES (3, 9, 3, 3, 8);

REPLACE INTO appointment(id, date, doctor_id, user_id) VALUES (1, '2021-12-28', 1, 2);
REPLACE INTO appointment(id, date, doctor_id, user_id) VALUES (2, '2021-12-27', 2, 3);
REPLACE INTO appointment(id, date, doctor_id, user_id) VALUES (3, '2021-12-26', 3, 4);

REPLACE INTO treatment(id, chamber, treatment_end, methods_of_treatment, treatment_start, doctor_id, user_id)  VALUES (1, 123, '2021-12-28', 'methodOfTreatment1', '2021-12-20', 1, 2);
REPLACE INTO treatment(id, chamber, treatment_end, methods_of_treatment, treatment_start, doctor_id, user_id)  VALUES (2, 321, '2021-12-28', 'methodOfTreatment2', '2021-12-19', 2, 3);
REPLACE INTO treatment(id, chamber, treatment_end, methods_of_treatment, treatment_start, doctor_id, user_id)  VALUES (3, 312, '2021-12-28', 'methodOfTreatment3', '2021-12-21', 3, 4);
REPLACE INTO treatment(id, chamber, treatment_end, methods_of_treatment, treatment_start, doctor_id, user_id)  VALUES (4, 321, '2021-12-28', 'methodOfTreatment2', '2021-12-19', 2, 2);

REPLACE INTO treatment_diagnose(id, diagnose_id) VALUES (1,1);
REPLACE INTO treatment_diagnose(id, diagnose_id) VALUES (1,2);
REPLACE INTO treatment_diagnose(id, diagnose_id) VALUES (1,3);
REPLACE INTO treatment_diagnose(id, diagnose_id) VALUES (2,2);
REPLACE INTO treatment_diagnose(id, diagnose_id) VALUES (3,3);

REPLACE INTO request_appointment(id, doctor_position, user_id) VALUES (1, 1, 1);
REPLACE INTO request_appointment(id, doctor_position, user_id) VALUES (2, 2, 2);
REPLACE INTO request_appointment(id, doctor_position, user_id) VALUES (3, 3, 3);