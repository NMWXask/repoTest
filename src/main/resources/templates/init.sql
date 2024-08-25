CREATE TABLE investigators (
                               id BIGINT PRIMARY KEY,
                               uuid VARCHAR(40) NOT NULL UNIQUE,
                               name VARCHAR(50),
                               surname VARCHAR(50),
                               department_id BIGINT,
                               city VARCHAR(255),
                               FOREIGN KEY (department_id) REFERENCES departments(department_id)
);

create table department(
                           department_id int primary key ,
                           department_name varchar(30)
);

CREATE TABLE cases (
                       case_id INT PRIMARY KEY,
                       case_description VARCHAR(255) NOT NULL
);

CREATE TABLE investigator_cases (
                                    investigator_id BIGINT,
                                    case_id INT,
                                    PRIMARY KEY (investigator_id, case_id),
                                    FOREIGN KEY (investigator_id) REFERENCES investigators(id),
                                    FOREIGN KEY (case_id) REFERENCES cases(case_id)
);