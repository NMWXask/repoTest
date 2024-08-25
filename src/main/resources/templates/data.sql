INSERT INTO investigators (id, uuid, name, surname, department_id, city)
VALUES (6, '550e8400-e29b-41d4-a716-446655440000', 'John', 'Doe', 1, 'New York'),
       (7, '550e8400-e29b-41d4-a716-446655440001', 'Jane', 'Smith', 2, 'Los Angeles'),
       (8, '550e8400-e29b-41d4-a716-446655440002', 'Alice', 'Johnson', 1, 'Chicago'),
       (9, '550e8400-e29b-41d4-a716-446655440003', 'Bob', 'Williams', 3, 'Houston'),
       (10, '550e8400-e29b-41d4-a716-446655440004', 'Charlie', 'Brown', 2, 'Phoenix'),
       (11, '550e8400-e29b-41d4-a716-446655440005', 'David', 'Jones', 3, 'Philadelphia'),
       (12, '550e8400-e29b-41d4-a716-446655440006', 'Eve', 'Garcia', 1, 'San Antonio'),
       (13, '550e8400-e29b-41d4-a716-446655440007', 'Frank', 'Martinez', 2, 'San Diego'),
       (14, '550e8400-e29b-41d4-a716-446655440008', 'Grace', 'Hernandez', 3, 'Dallas'),
       (15, '550e8400-e29b-41d4-a716-446655440009', 'Hank', 'Lopez', 1, 'San Jose');

INSERT INTO department (department_id, department_name) VALUES
                                                  (1, 'Research and Development'),
                                                  (2, 'Human Resources'),
                                                  (3, 'Finance');