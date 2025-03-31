package com.book.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public BookModel atualizarLivro(Long id, BookDTO bookDTO) {
        Optional<BookModel> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookModel livroExistente = optionalBook.get();
            livroExistente.setNome(bookDTO.getNome());
            livroExistente.setCategoria(bookDTO.getCategoria());
            return bookRepository.save(livroExistente);
        }
        throw new RuntimeException("Livro não encontrado");
    }
}
