package com.example.ativide.dao;

import jakarta.persistence.*;
import java.util.List;

import com.example.ativide.models.Autor;
import com.example.ativide.models.Livro;

public class LivroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public void salvar(Livro livro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
        em.close();
    }
    
    public Livro buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Livro livro = em.find(Livro.class, id);
        em.close();
        return livro;
    }
    
    public List<Livro> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Livro> livros = em.createQuery("FROM Livro", Livro.class).getResultList();
        em.close();
        return livros;
    }
    
    public void deletar(int id) {
        EntityManager em = emf.createEntityManager();
        Livro livro = em.find(Livro.class, id);
        if (livro != null) {
            em.getTransaction().begin();
            em.remove(livro);
            em.getTransaction().commit();
        }
        em.close();
    }
    
    public List<Autor> buscarAutoresPorLivro(int livroId) {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery("SELECT l.autores FROM Livro l WHERE l.id = :id", Autor.class)
            .setParameter("id", livroId).getResultList();
        em.close();
        return autores;
    }
}