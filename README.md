# 📘 Sistema de Gerenciamento de Biblioteca

## 📌 Descrição
Este projeto é um sistema de gerenciamento de biblioteca desenvolvido em **Java** utilizando **Jakarta Persistence API (JPA)** e **Hibernate** para persistência no **PostgreSQL**. O sistema permite cadastrar, listar, buscar e relacionar **livros, autores e editoras**.

## ⚙️ Tecnologias Utilizadas
- **Java** (JDK 17+)
- **Jakarta Persistence API (JPA)**
- **Hibernate** (ORM)
- **PostgreSQL**
- **Maven**

## 📂 Estrutura do Projeto
```
├── src/main/java/com/example/ativide/
│   ├── Main.java
│   ├── dao/
│   │   ├── LivroDAO.java
│   │   ├── AutorDAO.java
│   │   ├── EditoraDAO.java
│   ├── models/
│   │   ├── Livro.java
│   │   ├── Autor.java
│   │   ├── Editora.java
├──src/main/resources/META-INF/
│   │   ├── persistence.xml
└── pom.xml
```

## 📦 Configuração do Banco de Dados (PostgreSQL)
Antes de rodar o sistema, crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE biblioteca;
```

E configure o arquivo `persistence.xml` com suas credenciais:
```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/biblioteca" />
<property name="jakarta.persistence.jdbc.user" value="seu_usuario" />
<property name="jakarta.persistence.jdbc.password" value="sua_senha" />
```

## 🚀 Como Executar
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/biblioteca.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd biblioteca
   ```

## 🔍 Funcionalidades
- 📚 **Cadastrar, listar e buscar livros**
- 🖊 **Cadastrar, listar e buscar autores**
- 🏢 **Cadastrar, listar e buscar editoras**
- 🔄 **Relacionar livros com autores e editoras**

## 📌 Consultas Disponíveis
- 📖 Quais **autores** escreveram um livro
- 🖊 Quais **livros** um autor escreveu
- 🏢 Quais **editoras** publicaram um livro
- 📖 Quais **livros** foram publicados por uma editora
- 🖊 Quais **autores** publicaram livros em uma editora
- 🏢 Quais **editoras** publicaram livros de um autor

## 🛠 Possíveis Problemas e Soluções
1. **Erro: `No Persistence provider for EntityManager named biblioteca`**
   - Verifique se o `persistence.xml` está no caminho correto (`src/main/resources/META-INF/`).
   - Confirme se o nome da `persistence-unit` está igual ao informado no `Persistence.createEntityManagerFactory("biblioteca")`.

2. **Erro: `Connection refused. Check that the hostname and port are correct`**
   - Confirme se o PostgreSQL está rodando.
   - Verifique se a URL do banco de dados no `persistence.xml` está correta.

## 📜 Licença
Este projeto está sob a licença MIT. Sinta-se à vontade para usar e modificar! 🚀

