# Portal de Estágios - Scaffold

Este repositório contém um scaffold mínimo para o projeto *Portal de Estágios* (backend + frontend).
Objetivo: fornecer uma base pronta para desenvolvimento com endpoints básicos, scripts e instruções.

## Estrutura
- backend/  -> Spring Boot application (Java, Maven). Usa H2 em memória por padrão (fácil para testes).
- frontend/ -> React SPA mínima com páginas de exemplo.
- docker-compose.yml -> Compose para levantar Postgres (opcional) e instruções.
- README.md -> este arquivo.

## Como rodar (modo rápido - sem Docker)
### Backend
Requisitos: Java 17, Maven 3.x
```bash
cd backend
mvn spring-boot:run
```
API estará em `http://localhost:8080/api`

### Frontend (modo dev)
Requisitos: Node.js + npm
```bash
cd frontend
npm install
npm start
```
App front rodará em `http://localhost:3000`

## Como rodar com Docker (opcional)
O `docker-compose.yml` tem um serviço `postgres` configurado. Para rodar com Postgres:
1. Ajuste `backend/src/main/resources/application-postgres.properties` com usuário/senha/host se necessário.
2. Build e run:
```bash
docker-compose up --build
```

## Observações
- Essa é uma scaffold inicial. Ainda faltam: autenticação JWT, validações detalhadas, testes, documentação Swagger completa e a funcionalidade inovadora.
- Use como base para desenvolver as funcionalidades completas pedidas no enunciado.


Updates: autenticação JWT, Dockerfile backend, frontend completo com login/registro/CRUD, SQL init script.


DTOs adicionados para Usuário, Vaga e Empresa. Controllers agora usam DTOs para entrada/saída (melhor para documentação OpenAPI).


Environment & secrets
- The JWT secret is now read from `SPRING_JWT_SECRET` environment variable (see .env.example).

Users & passwords
- For security, users in the DB should be created via the API `/api/auth/register` which stores bcrypt-hashed passwords. The Flyway migration creates sample empresas and vagas but NOT users — create users by registering.
