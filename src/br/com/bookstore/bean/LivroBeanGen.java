package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.bookstore.integracao.LivroDao;
import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.GenrenciadorLivro;
import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroBeanModel.class)
public class LivroBeanGen implements LivroBeanModel {

	
	private GenrenciadorLivro gem;
	@EJB(name="BookStoreLivroEJB/LivroDAOImp",beanInterface=LivroDao.class)
	private LivroDao em;
	
	public LivroBeanGen (){
		gem = new GenrenciadorLivro();
	}
	
	@Override
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException {
		return em.searchLivro(dado);
	}

	@Override
	public void cadastrarLivro(Livro livro) throws LivroException {
			em.insertLivro(livro);	
	}

	@Override
	public void editarLivro(Livro livro) throws LivroException {
	
			em.updateLivro(livro);
	}

	@Override
	public List<Livro> listarLivros() {		
		return em.selectLivros();
	}

	@Override
	public Livro obterLivro(String isbn) {
		// TODO Auto-generated method stub
		return gem.getLivro(isbn);
	}

	@Override
	public void removerLivro(Livro livro) throws LivroException {
		em.deleteLivro(livro);

	}		

}
