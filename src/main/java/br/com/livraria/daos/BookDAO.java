package br.com.livraria.daos;

import br.com.livraria.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by desenvolvimento on 01/06/17.
 */
public class BookDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Book book) {
        manager.persist(book);
    }

    public List<Book> list() {
        return manager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class).getResultList();
    }
}


