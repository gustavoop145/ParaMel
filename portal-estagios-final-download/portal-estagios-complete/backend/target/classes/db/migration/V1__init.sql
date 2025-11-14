-- V1__init.sql - Flyway migration: create sample empresas and vagas
-- Tables are managed by JPA (hibernate.ddl-auto=update). This migration inserts sample data for Postgres.

INSERT INTO empresas (nome, cnpj, email, telefone, endereco, areas) VALUES
('MackTech','12.345.678/0001-00','contato@macktech.com','(11)99999-0000','Av. Exemplo, 100','TI,Desenvolvimento'),
('LojaModa','98.765.432/0001-11','rh@lojamoda.com','(11)98888-1111','Rua das Flores, 200','Varejo,Marketing');

-- Sample vagas - adjust empresa_id if necessary after migration
INSERT INTO vagas (titulo, descricao, area, localizacao, modalidade, carga_horaria, requisitos, encerrada, empresa_id) VALUES
('Estágio em Frontend','Desenvolvimento de componentes React','Desenvolvimento','São Paulo','HÍBRIDO','20h','React,HTML,CSS',false,1),
('Estágio em Marketing','Suporte ao time de Marketing digital','Marketing','Remoto','REMOTO','30h','Comunicação,Redes Sociais',false,2);
