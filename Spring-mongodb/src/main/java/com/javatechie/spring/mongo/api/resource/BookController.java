package com.javatechie.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongo.api.model.Book;
import com.javatechie.spring.mongo.api.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Agremamos un nuevo dato libro con id : " + book.getId();		
	}
	
	@GetMapping("/findAllBooks")
	public List<Book>	getBooks(){
		return repository.findAll();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Se elimino un dato del libro con el id : " + id;
	}
	
	@PutMapping("/update/{bookName}")
	public String upgrade(@RequestBody Book bookName) {
		repository.save(bookName);
		return "Se actualiza el nombre del libro : " + bookName.getBookName();
	}
	
	@PutMapping("/updateAll")
	public String upgradeAll(@RequestBody List<Book> bookName) {
		repository.saveAll(bookName);
		return "Se actualizan los datos libro : " + bookName.toString();
	}
		
}
