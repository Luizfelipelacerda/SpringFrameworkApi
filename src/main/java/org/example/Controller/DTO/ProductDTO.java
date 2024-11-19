package org.example.Controller.DTO;

public class ProductDTO {

    private String nome;

    private int category;

    private String imagem;

    private int preco;

    public ProductDTO() {
    }

    public ProductDTO(String nome, int category, String imagem, int preco) {
        this.nome = nome;
        this.category = category;
        this.imagem = imagem;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
