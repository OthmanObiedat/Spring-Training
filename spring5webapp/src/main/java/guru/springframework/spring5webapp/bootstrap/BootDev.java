package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositries.AuthorRepo;
import guru.springframework.spring5webapp.repositries.BookRepo;
import guru.springframework.spring5webapp.repositries.PublishRepo;

@Component
public class BootDev implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}

	private AuthorRepo authorRepo;
	private BookRepo bookRepo;
	private PublishRepo publishRepo;
	
	public BootDev(AuthorRepo authorRepo, BookRepo bookRepo,PublishRepo publishRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publishRepo = publishRepo;
		
	}

	private void initData() {
		
		Publisher pub1 = new Publisher("Publisher1", "Amman");
		publishRepo.save(pub1);
		
		Book b1 = new Book("Book1", "book123", pub1);
		Author aut1 = new Author("Book1Auth", "Book1AuthLastName");
		aut1.getBooks().add(b1);
		b1.getAuthors().add(aut1);
		authorRepo.save(aut1);
		bookRepo.save(b1);
		
		Book b2 = new Book("Book2", "book234", pub1);
		Author aut2 = new Author("Book2Auth", "Book2AuthLastName");
		aut2.getBooks().add(b2);
		b2.getAuthors().add(aut2);
		authorRepo.save(aut2);
		bookRepo.save(b2);
		
	}

}
