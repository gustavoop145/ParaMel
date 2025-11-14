-- init.sql: creates example empresas, usuarios and vagas for Postgres
-- IMPORTANT: If using JPA hibernate.ddl-auto=update the tables may be created automatically.
-- These inserts assume tables exist with columns matching entity names.

-- Sample empresas
INSERT INTO empresas (nome, cnpj, email, telefone, endereco, areas) VALUES
('MackTech','12.345.678/0001-00','contato@macktech.com','(11)99999-0000','Av. Exemplo, 100','TI,Desenvolvimento'),
('LojaModa','98.765.432/0001-11','rh@lojamoda.com','(11)98888-1111','Rua das Flores, 200','Varejo,Marketing');

-- Sample usuarios (senha 'senha' criptografada será criada ao registrar via API)
-- We insert only emails and profiles to be replaced if used directly.
INSERT INTO usuarios (nome, email, senha, perfil) VALUES
('Admin','admin@portal.com','{bcrypt}$2a$10$7q1pDqvDP9/SampleHash','ADMIN'),
('Empresa','empresa@portal.com','{bcrypt}$2a$10$7q1pDqvDP9/SampleHash','EMPRESA'),
('Aluno','aluno@portal.com','{bcrypt}$2a$10$7q1pDqvDP9/SampleHash','ESTUDANTE');

-- Sample vagas (note: empresa_id must match existing empresa ids)
-- If empresa ids differ adjust accordingly after DB creation
INSERT INTO vagas (titulo, descricao, area, localizacao, modalidade, carga_horaria, requisitos, encerrada, empresa_id) VALUES
('Estágio em Frontend','Desenvolvimento de componentes React','Desenvolvimento','São Paulo','HÍBRIDO','20h','React,HTML,CSS',false,1),
('Estágio em Marketing','Suporte ao time de Marketing digital','Marketing','Remoto','REMOTO','30h','Comunicação,Redes Sociais',false,2);
