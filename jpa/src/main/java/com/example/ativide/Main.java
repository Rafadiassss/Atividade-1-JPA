package com.example.ativide;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAO();
        AutorDAO autorDAO = new AutorDAO();
        EditoraDAO editoraDAO = new EditoraDAO();

        try {
            System.out.println("Conexão com PostgreSQL via Hibernate funcionando!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        // Criar uma editora
        Editora editora = new Editora();
        editora.setNome("Editora ABC");
        editoraDAO.salvar(editora);

        // Criar autores
        Autor autor1 = new Autor();
        autor1.setNome("Autor João");
        autorDAO.salvar(autor1);

        Autor autor2 = new Autor();
        autor2.setNome("Autor Maria");
        autorDAO.salvar(autor2);

        // Criar um livro com múltiplos autores
        Livro livro = new Livro();
        livro.setTitulo("Livro de Hibernate");
        livro.setAnoPub(2024);
        livro.setIsbn("987654321");
        livro.setEditora(editora);
        livro.setAutores(Set.of(autor1, autor2));
        livroDAO.salvar(livro);

        // Buscar autores por livro
System.out.println("----------------------------");
System.out.println("\n Autores do Livro '" + livro.getTitulo() + "':");
livroDAO.buscarAutoresPorLivro(livro.getId()).forEach(a -> System.out.println("➡ " + a.getNome()));
System.out.println("----------------------------");

// Buscar livros por autor
System.out.println("----------------------------");
System.out.println("\n Livros do Autor '" + autor1.getNome() + "':");
autorDAO.buscarLivrosPorAutor(autor1.getId()).forEach(l -> System.out.println("➡ " + l.getTitulo()));
System.out.println("----------------------------");

// Buscar editora por livro
System.out.println("----------------------------");
System.out.println("\n Editora do Livro '" + livro.getTitulo() + "':");
System.out.println("➡ " + livro.getEditora().getNome());
System.out.println("----------------------------");

// Buscar livros por editora
System.out.println("----------------------------");
System.out.println("\n Livros da Editora '" + editora.getNome() + "':");
editoraDAO.buscarLivrosPorEditora(editora.getId()).forEach(l -> System.out.println(" " + l.getTitulo()));
System.out.println("----------------------------");

// Buscar autores por editora
System.out.println("----------------------------");
System.out.println("\n Autores que publicaram na Editora '" + editora.getNome() + "':");
editoraDAO.buscarAutoresPorEditora(editora.getId()).forEach(a -> System.out.println(" " + a.getNome()));
System.out.println("----------------------------");

// Buscar editoras por autor
System.out.println("----------------------------");
System.out.println("\n Editoras que publicaram livros do Autor '" + autor1.getNome() + "':");
autorDAO.buscarEditorasPorAutor(autor1.getId()).forEach(e -> System.out.println(" " + e.getNome()));
System.out.println("----------------------------");
}
}