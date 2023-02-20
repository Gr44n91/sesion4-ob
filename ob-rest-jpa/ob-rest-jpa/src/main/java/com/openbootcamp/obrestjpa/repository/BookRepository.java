package com.openbootcamp.obrestjpa.repository;

import com.openbootcamp.obrestjpa.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
