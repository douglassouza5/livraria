package br.com.livraria.managedbeans;

import br.com.livraria.daos.AuthorDAO;
import br.com.livraria.daos.BookDAO;
import br.com.livraria.models.Author;
import br.com.livraria.models.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by desenvolvimento on 31/05/17.
 */
@Model
public class AdminBooksBean {

    private Book product = new Book();


    private List<Author> authors = new ArrayList<Author>();

    private List<Integer> selectedAuthorsIds = new ArrayList<>();


    @PostConstruct
    public void loadObjects() {
        this.authors = authorDAO.list();
    }

    @Inject
    public AdminBooksBean(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        this.authors = authorDAO.list();
    }

    @Inject
    private BookDAO bookDAO;

    @Inject
    private AuthorDAO authorDAO;

    @Transactional
    public void save() {
        populateBookAuthor();
        bookDAO.save(product);
    }

    private void populateBookAuthor() {
    //Essa linha imprime => [3, 1, 2]=====
        System.out.println(selectedAuthorsIds + "=====");
        selectedAuthorsIds.stream().map((id) -> {
            return new Author(id);
        }).forEach(product::add);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Integer> getSelectedAuthorsIds() {
        return selectedAuthorsIds;
    }

    public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
        this.selectedAuthorsIds = selectedAuthorsIds;
    }

    public Book getProduct() {
        return product;
    }
}
