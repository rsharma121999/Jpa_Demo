package com.example.demojpa1.Repository;

import com.example.demojpa1.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {


    public List<Book> findByAuthorName(String name);

    @Query(value = "select * from book b where b.author_name=:name",nativeQuery = true)
    public List<Book> findByAuthor(String name);

    @Query("select b  from Book b where b.authorName=:name")
    public List<Book> findByAuthors(String name);
}
