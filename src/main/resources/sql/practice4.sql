-- Active: 1785826856181@@127.0.0.1@3306@practice4

-- 1. 학생 등록
INSERT INTO student (student_name, create_date, up_date_time)
VALUES
('유재석', NOW(), NOW()),
('강호동', NOW(), NOW()),
('신동엽', NOW(), NOW());


-- 2. 과정 등록
INSERT INTO course (course_name, create_date, up_date_time)
VALUES
('Java 기초', NOW(), NOW()),
('Spring Boot', NOW(), NOW()),
('MySQL', NOW(), NOW());


-- 3. 수강 등록
INSERT INTO enroll
(status, course_id, student_id, create_date, up_date_time)
VALUES
('수강중', 1, 1, NOW(), NOW()),
('수강중', 2, 2, NOW(), NOW()),
('수강중', 3, 3, NOW(), NOW());