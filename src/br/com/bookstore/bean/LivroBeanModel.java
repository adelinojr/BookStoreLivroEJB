package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;

/**
 * Fachada que concentra o ponto de entrada para todas
 * as operações que envolvem o gerenciamento de livros EJB Livro.
 * 
 * @author Adelino Ferreira- bugass@gmail.com
 */
public interface LivroBeanModel {

	/**
	 * Realiza o cadastro de um novo Livro.
	 * 
	 * @param livro o livro a ser cadastrado.
	 * @throws LivroException Caso o livro a ser cadastrado já exista na base de dados ou possua alguma
	 * 							informação inválida..
	 */
	public void cadastrarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Exclui um livro da base de dados da aplicação.
	 * 
	 * @param livro O Livro a ser removido
	 * @throws LivroException Caso o livro a ser removido não exista.
	 */
	public void removerLivro( Livro livro ) throws LivroException;
	
	/**
	 * Permite modificar as informações cadastrais de um livro. Não deve ser possível alterar o ISBN
	 * do livro. As informações atuais do livro existente na base de dados serão subistituídas pelas 
	 * informações fornecidas através do objeto passado como parâmetro.
	 * 
	 * @param livro O livro cujas informações serão modificadas.
	 * @throws LivroException Caso existam restrições nos dados fornecidos através do novo objeto passado
	 * 							como parâmetro ou o livro a ser modificado não exista nas bases de dados.
	 */
	public void editarLivro( Livro livro ) throws LivroException;
	
	/**
	 * Obtém uma lista com todos os livros cadastrados na aplicação.
	 * 
	 * @return Uma lista com todos os livros cadastrados, ou uma lista vazia, caso não exista nenhum
	 * 			livro cadastrado.
	 */
	public List<Livro> listarLivros();

	/**
	 * Obtém o livro representado pelo ISBN passado como parâmetro. 
	 * 
	 * @param isbn o ISBN usado para recuperar o livro específico.
	 * @return o livro cujo ISBN foi passado como parâmetro, ou null, caso não exista livro cadastrado
	 * 			com o ISBN em questão.
	 * @throws LivroException 
	 */
	public Livro obterLivro( String isbn ) throws LivroException;
	
	
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException;
	
}
