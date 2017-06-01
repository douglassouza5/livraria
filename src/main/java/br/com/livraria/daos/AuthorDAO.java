package br.com.livraria.daos;

import br.com.livraria.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by desenvolvimento on 01/06/17.
 */
public class AuthorDAO {
    @PersistenceContext
    private EntityManager manager;

    public List<Author> list() {
        return manager.createQuery(
                "select a from Author a order by a.name asc", Author.class)
                .getResultList();
    }

}
