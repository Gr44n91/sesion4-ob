package com.openbootcamp.obrestjpa.controllers;

import com.openbootcamp.obrestjpa.entites.Book;
import com.openbootcamp.obrestjpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    //Para usar el repositorio tenemos que incluir la interfaz en el controller
    private BookRepository bookRepository;
    //Despues tenemos que crear el constructor de la interfaz
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //CRUD sobre la entidad book

    //Buscar todos los libros de la bbdd(Devuelve una Lista)
    @GetMapping("/api/books")//para devolver listas se usa la entidad en plurar
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    //Buscar todos los libros segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        //Debemos crar el envoltorio optional de book
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Crear un libro
    @PostMapping("/api/books") //RequuestBody quiere decir que el book va en el cuerpo de la peticion
    public Book createBook(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }
    //Actualizar un libro en bbdd
    //borrar un libro por id

}
