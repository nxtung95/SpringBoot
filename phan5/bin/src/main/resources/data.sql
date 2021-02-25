 INSERT INTO users(id, name, email, password) VALUES
 (1, 'Alice', 'nx@gmail.com', '$2a$10$D6oAYrEbTCCQemRo5ATgq.6vDJ.tL6bzrIT5ZE00m1Ex7I4yHTmzO'),
 (2, 'Blice', 'nx1@gmail.com', '$2a$10$D6oAYrEbTCCQemRo5ATgq.6vDJ.tL6bzrIT5ZE00m1Ex7I4yHTmzO');
 
INSERT INTO students(student_id, year) VALUES
 (1, 3);
 
 INSERT INTO teachers(teacher_id, phone, experiences) VALUES
 (2, '01245464576', 5);
 
 INSERT INTO courses(id, teacher_id, name, description, location, opened) VALUES
 (1, 2, 'Spring _Boot Fundamental', 'Description 1', 'Hanoi CS1', '2021-02-15'),
 (2, 2, 'Spring Boot Microservice', 'Description 2', 'Hanoi CS1', '2021-02-16');