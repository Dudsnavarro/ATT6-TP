package com.book.demo.book;

public class BookDTO {

    private Long id;
    private String nome;
    private String categoria;

    public BookModel transformaParaObjeto(){
        return new BookModel(this.nome ,this.categoria);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
