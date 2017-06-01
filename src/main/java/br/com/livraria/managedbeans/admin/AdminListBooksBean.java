package br.com.livraria.managedbeans.admin;

import br.com.livraria.daos.BookDAO;
import br.com.livraria.models.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by desenvolvimento on 01/06/17.
 */
@Model
public class AdminListBooksBean {
    @Inject
    private BookDAO bookDAO;
    private List<Book> books = new ArrayList<>();
    @PostConstruct
    private void loadObjects(){
        this.books = bookDAO.list();
    }
    public List<Book> getBooks() {
        return books;
    }
}
