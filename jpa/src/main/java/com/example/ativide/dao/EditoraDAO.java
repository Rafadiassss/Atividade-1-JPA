package com.example.ativide.dao;

import jakarta.persistence.*;
import java.util.List;

import com.example.ativide.models.Autor;
import com.example.ativide.models.Editora;
import com.example.ativide.models.Livro;

public class EditoraDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");

    public void salvar(Editora editora) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(editora);
        em.getTransaction().commit();
        em.close();
    }
    
    public Editora buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Editora editora = em.find(Editora.class, id);
        em.close();
        return editora;
    }
    
    public List<Editora> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Editora> editoras = em.createQuery("FROM Editora", Editora.class).getResultList();
        em.close();
        return editoras;
    }

    public List<Livro> buscarLivrosPorEditora(int editoraId) {
        EntityManager em = emf.createEntityManager();
        List<Livro> livros = em.createQuery("SELECT l FROM Livro l WHERE l.editora.id = :id", Livro.class)
            .setParameter("id", editoraId).getResultList();
        em.close();
        return livros;
    }
    
    public List<Autor> buscarAutoresPorEditora(int editoraId) {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery(
            "SELECT DISTINCT a FROM Autor a JOIN a.livros l WHERE l.editora.id = :id", Autor.class)
            .setParameter("id", editoraId).getResultList();
        em.close();
        return autores;
    }
}
