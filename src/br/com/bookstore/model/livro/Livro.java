package br.com.bookstore.model.livro;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Classe que representa um Livro. :-)
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
public class Livro implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private Integer id;
	
	private String titulo;
	private String autor;
	private String editora;
	
	private Genero categoria;
	
	private int edicao;
	private int ano;
	private int numeroDePaginas;
	
	private String resenha;
	
	/* Para facilitar, estamos usando um BigInteger, que representa
	 * o pre�o do livro em centavos. No momento em que precisarmos
	 * mostrar o pre�o, basta usar uma m�scara ou converter que mostre
	 * como moeda. */
	private BigInteger preco;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Genero getCategoria() {
		return categoria;
	}

	public void setCategoria(Genero categoria) {
		this.categoria = categoria;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	public String getResenha() {
		return resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}

	public BigInteger getPreco() {
		return preco;
	}

	public void setPreco(BigInteger preco) {
		this.preco = preco;
	}

	
	
	@Override
	public boolean equals(Object arg0) {
		boolean teste = false;
		if( arg0 instanceof Livro){
			 Livro livroRecebido = (Livro) arg0;
			if( this.getIsbn().equals(livroRecebido.getIsbn())){
				teste = true;
			}
		}
		return teste;
	}

	@Override
	public String toString() {
		return "Livro [ano=" + ano + ", autor=" + autor + ", categoria="
				+ categoria + ", edicao=" + edicao + ", editora=" + editora
				+ ", isbn=" + isbn + ", numeroDePaginas=" + numeroDePaginas
				+ ", preco=" + preco + ", resenha=" + resenha + ", titulo="
				+ titulo + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Livro livro =  (Livro) super.clone();
		return livro;
	}
	
	public Object cloneLivro(){
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
