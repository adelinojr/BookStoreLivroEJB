package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;

/**
 * Fachada que concentra o ponto de entrada para todas
 * as opera��es que envolvem o gerenciamento de livros EJB Livro.
 * 
 * @author Adelino Ferreira- bugass@gmail.com
 */
public interface LivroBeanModel {

	/**
	 * Realiza o cadastro de um novo Livro.
	 * 
	 * @param livro o livro a ser cadastrado.
	 * @throws LivroException Caso o livro a ser cadastrado j� exista na base de dados ou possua alguma
	 * 							informa��o inv�lida..
	 */
	public void cadastrarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Exclui um livro da base de dados da aplica��o.
	 * 
	 * @param livro O Livro a ser removido
	 * @throws LivroException Caso o livro a ser removido n�o exista.
	 */
	public void removerLivro( Livro livro ) throws LivroException;
	
	/**
	 * Permite modificar as informa��es cadastrais de um livro. N�o deve ser poss�vel alterar o ISBN
	 * do livro. As informa��es atuais do livro existente na base de dados ser�o subistitu�das pelas 
	 * informa��es fornecidas atrav�s do objeto passado como par�metro.
	 * 
	 * @param livro O livro cujas informa��es ser�o modificadas.
	 * @throws LivroException Caso existam restri��es nos dados fornecidos atrav�s do novo objeto passado
	 * 							como par�metro ou o livro a ser modificado n�o exista nas bases de dados.
	 */
	public void editarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Obt�m uma lista com todos os livros cadastrados na aplica��o.
	 * 
	 * @return Uma lista com todos os livros cadastrados, ou uma lista vazia, caso n�o exista nenhum
	 * 			livro cadastrado.
	 */
	public List<Livro> listarLivros();

	/**
	 * Obt�m o livro representado pelo ISBN passado como par�metro. 
	 * 
	 * @param isbn o ISBN usado para recuperar o livro espec�fico.
	 * @return o livro cujo ISBN foi passado como par�metro, ou null, caso n�o exista livro cadastrado
	 * 			com o ISBN em quest�o.
	 * @throws LivroException 
	 */
	public Livro obterLivro( String isbn ) throws LivroException;
	
	
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException;
	
}
