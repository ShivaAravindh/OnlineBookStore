package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.onllinebookstore.dto.Book;
import com.onllinebookstore.dto.Customer;

public class BookDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("onlinebookstore");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();	
	
	public void saveBook(Book bk) {
		List <Book> l = new ArrayList<Book>();
		l.add(bk);
		et.begin();
		em.persist(l);
		et.commit();
	}
	public Book deleteBook(int id ) {
		Book bk = em.find(Book.class, id);
		if(bk!=null) {
			et.begin();
			em.remove(bk);
			et.commit();
			return bk;
		}
		return null;
	}
	
	public void updateBook(int id , String name,String author, String genre) {
		
		Book bk = em.find(Book.class, id);
		if(bk!=null) {
			bk.setBookName(name);
			bk.setAuthorName(author);
			bk.setGenre(genre);
			et.begin();
			em.merge(bk);
			et.commit();
		}
   }
	
}
