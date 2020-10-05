INSERT INTO USER (id, full_name, email, nickname, created_at) VALUES (0,'Prfessor Pardal', 'pardal@tms.com.br', 'Pardal', sysdate());
INSERT INTO USER (id, full_name, email, nickname, created_at) VALUES (1,'Tio Patilhas', 'patinhas@tms.com.br', 'patinhas', sysdate());
INSERT INTO USER (id, full_name, email, nickname, created_at) VALUES (2,'Huginho', 'huguinho@tms.com.br', 'huguinho', sysdate());
INSERT INTO USER (id, full_name, email, nickname, created_at) VALUES (3,'Zezinho', 'zezinho@tms.com.br', 'zezinho', sysdate());
INSERT INTO USER (id, full_name, email, nickname, created_at) VALUES (4,'Luizinho', 'luizinho@tms.com.br', 'luizinho', sysdate());

INSERT INTO COMPANY (id, name, slug, created_at) VALUES (1,'Pague Seguro', 'XPTO-001', sysdate());
INSERT INTO COMPANY (id, name, slug, created_at) VALUES (2,'Casa do Dinheiro', 'XPTO-002', sysdate());

INSERT INTO CHALLENGE (id, name, slug, created_at) VALUES (1,'JAVA COM SPRINGBOOT', 'XPTO-003', sysdate());
INSERT INTO CHALLENGE (id, name, slug, created_at) VALUES (2,'SPRINGBOOT COM REACT.js', 'XPTO-004', sysdate());

INSERT INTO ACCELERATION (id, name, slug, challenge_id, created_at) VALUES (1,'ACELERACÃO COM JAVA E SPRINGBOOT',  'XPTO-005', 1, sysdate());
INSERT INTO ACCELERATION (id, name, slug, challenge_id, created_at) VALUES (2,'ACELERACÃO COM REACT',  'XPTO-006', 2, sysdate());

INSERT INTO CANDIDATE(user_id, acceleration_id, company_id, status, created_at) VALUES (0, 1, 1, 1, sysdate());
INSERT INTO CANDIDATE(user_id, acceleration_id, company_id, status, created_at) VALUES (1, 2, 1, 1, sysdate());
INSERT INTO CANDIDATE(user_id, acceleration_id, company_id, status, created_at) VALUES (3, 2, 1, 1, sysdate());
INSERT INTO CANDIDATE(user_id, acceleration_id, company_id, status, created_at) VALUES (4, 2, 1, 1, sysdate());