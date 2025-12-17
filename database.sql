-- Oprettelse af project-tabel
CREATE TABLE project (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(255),
                         customer VARCHAR(255),
                         deadline DATE
);

-- Oprettelse af task-tabel
CREATE TABLE task (
                      id BIGINT PRIMARY KEY,
                      name VARCHAR(255),
                      estimated_hours INT,
                      project_id BIGINT,
                      FOREIGN KEY (project_id) REFERENCES project(id)
);

-- Indsættelse af testdata
INSERT INTO project (id, name, customer, deadline)
VALUES (1, 'ERP Implementering', 'Alpha Solutions', '2025-06-01');

INSERT INTO task (id, name, estimated_hours, project_id)
VALUES (1, 'Analyse', 40, 1);

INSERT INTO task (id, name, estimated_hours, project_id)
VALUES (2, 'Udvikling', 120, 1);
