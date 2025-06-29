package com.pve.bookstore.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pve.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
