package com.example.ativide;

import jakarta.persistence.*;
import java.util.List;

public class AutorDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    
    public void salvar(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }
    
    public Autor buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, id);
        em.close();
        return autor;
    }
    
    public List<Autor> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery("FROM Autor", Autor.class).getResultList();
        em.close();
        return autores;
    }
    public List<Editora> buscarEditorasPorAutor(int autorId) {
        EntityManager em = emf.createEntityManager();
        List<Editora> editoras = em.createQuery(
            "SELECT DISTINCT l.editora FROM Livro l JOIN l.autores a WHERE a.id = :id", Editora.class)
            .setParameter("id", autorId).getResultList();
        em.close();
        return editoras;
    }
    public List<Livro> buscarLivrosPorAutor(int autorId) {
        EntityManager em = emf.createEntityManager();
        List<Livro> livros = em.createQuery("SELECT a.livros FROM Autor a WHERE a.id = :id", Livro.class)
            .setParameter("id", autorId).getResultList();
        em.close();
        return livros;
    }
    
    
}
