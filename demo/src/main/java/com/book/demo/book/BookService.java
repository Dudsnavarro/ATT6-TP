package com.book.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> findAll(){
        return bookRepository.findAll();
    }

    public BookModel criarLivro(BookModel bookModel){
        return bookRepository.save(bookModel);
    }

    public void deletarLivro(Long id){
        bookRepository.deleteById(id);
    }
}
