# CS-Commerce

CS-Commerce é um projeto de e-commerce desenvolvido para fins de estudo, utilizando Java (Spring Boot) no backend. O objetivo é proporcionar uma base sólida para quem deseja aprender sobre desenvolvimento de APIs REST, autenticação, rotas protegidas, manipulação de produtos, pedidos e usuários.

## Sumário
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Rotas da API](#rotas-da-api)
- [Autenticação e Segurança](#autenticação-e-segurança)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Como Contribuir](#como-contribuir)
- [Licença](#licença)
- [Contato](#contato)

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security (OAuth2, JWT)
- H2 Database (para testes)
- Maven

---

## Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven

### Passos para rodar o backend
1. Clone o repositório:
   ```sh
   git clone <url-do-repositorio>
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd cs-commerce
   ```
3. Execute o backend:
   ```sh
   ./mvnw spring-boot:run
   ```
   O backend estará disponível em `http://localhost:8080`.

### Banco de Dados
- O projeto utiliza H2 Database em memória para facilitar os testes e o desenvolvimento.
- Os dados são inicializados automaticamente via scripts SQL em `src/main/resources/import.sql`.
- Para acessar o console do H2, acesse: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

---

## Funcionalidades

- Cadastro e autenticação de usuários
- Listagem, cadastro, edição e remoção de produtos (admin)
- Listagem de produtos para clientes
- Cadastro de categorias
- Realização de pedidos
- Visualização de pedidos do usuário
- Rotas protegidas por autenticação e perfil
- Validações e tratamento de erros

---

## Rotas da API

### Autenticação
- `POST /oauth/token` — Realiza login e retorna o token JWT

### Usuários
- `GET /users` — Lista todos os usuários (admin)
- `GET /users/{id}` — Busca usuário por ID
- `POST /users` — Cria novo usuário

### Produtos
- `GET /products` — Lista todos os produtos
- `GET /products/{id}` — Detalhes de um produto
- `POST /products` — Cria novo produto (admin)
- `PUT /products/{id}` — Atualiza produto (admin)
- `DELETE /products/{id}` — Remove produto (admin)

### Pedidos
- `GET /orders` — Lista pedidos do usuário autenticado
- `GET /orders/{id}` — Detalhes de um pedido
- `POST /orders` — Cria novo pedido

### Categorias
- `GET /categories` — Lista todas as categorias
- `POST /categories` — Cria nova categoria (admin)

---

## Autenticação e Segurança

O sistema utiliza autenticação baseada em JWT (JSON Web Token) e OAuth2. Ao fazer login, o usuário recebe um token que deve ser enviado no header `Authorization` das requisições protegidas.

- **Login:**
  - Envie e-mail e senha para `/oauth/token`.
  - Se autenticado, recebe um token JWT.
  - O token deve ser enviado no header `Authorization: Bearer <token>` nas rotas protegidas.

- **Proteção de Rotas:**
  - Algumas rotas só podem ser acessadas por usuários autenticados.
  - Rotas administrativas exigem perfil de admin.

- **Perfis de Usuário:**
  - Usuário comum: pode consultar produtos, criar pedidos e visualizar seus próprios pedidos.
  - Admin: pode gerenciar produtos, categorias e visualizar todos os usuários.

- **Tratamento de Erros:**
  - As respostas de erro seguem o padrão de mensagens detalhadas, facilitando o debug e o uso da API.

---

## Estrutura de Pastas

```
cs-commerce/
├── src/
│   ├── main/java/com/cleiversoares/cscommerce/
│   │   ├── controllers/   # Controllers REST
│   │   ├── dto/           # Data Transfer Objects
│   │   ├── entities/      # Entidades JPA
│   │   ├── repositories/  # Repositórios JPA
│   │   ├── services/      # Regras de negócio
│   │   ├── config/        # Configurações de segurança e aplicação
│   │   └── ...
│   └── resources/         # Configurações e scripts SQL
└── ...
```

---

## Como Contribuir

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b minha-feature`)
3. Faça commit das suas alterações (`git commit -m 'feat: minha feature'`)
4. Faça push para a branch (`git push origin minha-feature`)
5. Abra um Pull Request

---

## Licença

Este projeto é para fins de estudo e não possui licença comercial. Sinta-se à vontade para usar, modificar e compartilhar!

---

## Contato

Dúvidas ou sugestões? Entre em contato pelo GitHub ou abra uma issue!
