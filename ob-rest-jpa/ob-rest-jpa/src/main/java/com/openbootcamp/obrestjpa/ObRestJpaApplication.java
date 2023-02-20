package com.openbootcamp.obrestjpa;

import com.openbootcamp.obrestjpa.entites.Book;
import com.openbootcamp.obrestjpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);
		//A partir de aqui ya podemos usar metodos CRUD en el main

		//Crear libro
		Book libro1 = new Book(null, "Padre Rico Padre Pobre", "Robert", 140, 14.15, LocalDate.of(2000, 6, 10), true);
		Book libro2 = new Book(null, "Libro 2", "Robert", 140, 14.15, LocalDate.of(2000, 6, 10), true);
		//Almacenar un libro
		repository.save(libro1);
		repository.save(libro2);

		//Recuperar todos los libros
		System.out.println("Numero de libros en bbdd: " + repository.findAll().size());
		//Borrar un libro
		//repository.deleteById(1L);

		System.out.println("Numero de libros en bbdd: " + repository.findAll().size());

	}

}
