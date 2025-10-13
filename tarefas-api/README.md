# Tarefas API

**Nome completo:** Gabriel Sponton Beretta  
**RU:** 4573718

## Executar
- `./mvnw spring-boot:run` (Linux/Mac)  
- `mvnw.cmd spring-boot:run` (Windows)  
- `mvn spring-boot:run` (se não usar wrapper)

A API roda padrão em `http://localhost:8080`.

## Endpoints
- GET  /api/tarefas  
- POST /api/tarefas

## Importar collection Postman
- Arquivo da collection: `postman_collection.json` (incluir na raiz do repositório).  
- No Postman: File > Import > selecione `postman_collection.json`.  
- Ajuste host/porta nas requests se a sua aplicação rodar em outra porta.

## Evidências exigidas (passo a passo)
1. Criar tarefa (POST /api/tarefas)  
   - Body: `{"nome":"Registro do aluno - Evidência Inserção","dataEntrega":"2025-09-20","responsavel":"Gabriel Sponton Beretta - RU 4573718"}`  
   - Esperado: retorno com os mesmos campos e um **id** (201 ou 200).
2. Listar tarefas (GET /api/tarefas)  
   - Esperado: lista contendo o registro criado com **responsavel** igual ao seu nome e RU.
3. Atualizar tarefa (PUT /api/tarefas/{id})  
   - Ajuste `{id}` conforme o id retornado no POST. Body de atualização.  
   - Esperado: 200 OK com dados atualizados.
4. Remover tarefa (DELETE /api/tarefas/{id})  
   - Ajuste `{id}` conforme necessário.  
   - Esperado: 204 No Content; verifique com GET retornando 404 ou listagem sem o item.

## Notas
- Se o avaliador conferir commits, configure seu git antes de commitar:
  - `git config user.name "Gabriel Sponton Beretta"`  
  - `git config user.email "seu@email.exemplo"`
- A collection de exemplo que você comparou está neste repositório para referência .