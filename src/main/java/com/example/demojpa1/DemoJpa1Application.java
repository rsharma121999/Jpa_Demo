package com.example.demojpa1;

import com.example.demojpa1.Models.Book;
import com.example.demojpa1.Models.BookCategory;
import com.example.demojpa1.Repository.BookCategoryRepository;
import com.example.demojpa1.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoJpa1Application implements CommandLineRunner {
//CommandLineRunner used to run the controller within the IDE you don't have to run the application and hit api on postman.
	public static void main(String[] args) {
		SpringApplication.run(DemoJpa1Application.class, args);
	}


	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Book> Probooklist = new ArrayList<>();
		List<Book> NonProgramBookList = new ArrayList<>();
		Book b1 = new Book("ABC","Rahul",40);
		Book b2 = new Book("xyz","Han",30);
		Book b3 = new Book("JAVA","John",400);
		Book b4 = new Book("Python","Ram",230);
		Probooklist.add(b1);
		Probooklist.add(b2);
		NonProgramBookList.add(b3);
		NonProgramBookList.add(b4);
		bookRepository.saveAll(Probooklist);
		bookRepository.saveAll(NonProgramBookList);
		List<Book> datalist = bookRepository.findAll();
		System.out.println(datalist);
		System.out.println(bookRepository.findByAuthorName("mad"));
		System.out.println(bookRepository.findByAuthor("mad"));
		System.out.println(bookRepository.findByAuthors("Rahul"));

		bookCategoryRepository.save(new BookCategory("Non Programming"));
		bookCategoryRepository.save(new BookCategory("Programming",Probooklist));



	}
}
