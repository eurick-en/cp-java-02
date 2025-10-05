# CP 05 - Projeto Biblioteca Online

## Descrição
Aplicação web simples para gerenciar livros e empréstimos de uma biblioteca comunitária, desenvolvida com **Spring Boot**, **MVC**, **JPA** e **Thymeleaf**.

O sistema permite:
- Cadastro e gerenciamento de livros
- Cadastro de usuários
- Registro e controle de empréstimos
- Listagem de livros e empréstimos ativos

---

## Tecnologias Utilizadas
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database** (ou MySQL, se preferirem)
- **Maven** para gerenciamento de dependências

---

## Funcionalidades

### 1. Cadastro de Livros
- Cada livro possui:
  - Título
  - Autor
  - Ano de publicação
  - Status (Disponível ou Emprestado)
- Funcionalidades:
  - Inserir, editar e excluir livros
  - Ao cadastrar, o livro começa com status **Disponível**

### 2. Cadastro de Usuários
- Cada usuário possui:
  - Nome
  - E-mail
- Funcionalidades:
  - Inserir e listar usuários
  - Validação de e-mail válido

### 3. Registro de Empréstimos
- Cada empréstimo vincula:
  - Um livro (status muda para **Emprestado**)
  - Um usuário
  - Data de retirada
  - Data prevista para devolução
- Funcionalidade:
  - Ao devolver o livro, o status volta para **Disponível**
  - Data de devolução deve ser posterior à data de retirada

### 4. Listagens
- Listar todos os livros cadastrados
- Listar apenas livros disponíveis
- Listar empréstimos ativos (usuário, livro e data prevista de devolução)

---


