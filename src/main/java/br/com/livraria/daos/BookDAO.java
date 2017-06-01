package br.com.livraria.daos;

import br.com.livraria.models.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by desenvolvimento on 01/06/17.
 */
public class BookDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Book book){
        manager.persist(book);
    }
}


