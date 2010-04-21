package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.GenrenciadorLivro;
import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroBeanModel.class)
public class LivroBeanGen implements LivroBeanModel {

	
	private GenrenciadorLivro gem;
	
	public LivroBeanGen (){
		gem = new GenrenciadorLivro();
	}
	
	@Override
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException {
		return gem.buscarLivro(dado);
	}

	@Override
	public void cadastrarLivro(Livro livro) throws LivroException {
		
		gem.persist(livro);
	}

	@Override
	public void editarLivro(Livro livro) throws LivroException {
	
			gem.editar(livro);
	}

	@Override
	public List<Livro> listarLivros() {
		// TODO Auto-generated method stub
		return gem.getTodosOsLivro();
	}

	@Override
	public Livro obterLivro(String isbn) {
		// TODO Auto-generated method stub
		return gem.getLivro(isbn);
	}

	@Override
	public void removerLivro(Livro livro) throws LivroException {
		gem.remove(livro);

	}

}
