package com.book.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> findAll(){
        List<BookModel> bookModel = bookService.findAll();
        return ResponseEntity.ok().body(bookModel);
    }
    @PostMapping
    public ResponseEntity<BookModel> criarLivro(@RequestBody BookDTO bookDTO){
        BookModel response = bookService.criarLivro(bookDTO.transformaParaObjeto());
        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPeloId(@PathVariable Long id){
        bookService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }



}
