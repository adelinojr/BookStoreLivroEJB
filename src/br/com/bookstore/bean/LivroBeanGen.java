package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.GenrenciadorLivro;
import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroBeanModel.class)
public class LivroBeanGen implements LivroBeanModel {

	@PersistenceContext(name="BookStoreLivro")
	private EntityManager em;	
	
	private GenrenciadorLivro gem;
	
	public LivroBeanGen (){
		gem = new GenrenciadorLivro(em);
	}
	
	@Override
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException {
		return gem.buscarLivro(dado);
	}

	@Override
	public void cadastrarLivro(Livro livro) throws LivroException {
		
		em.persist(livro);
	   //	gem.persist(livro);
	}

	@Override
	public void editarLivro(Livro livro) throws LivroException {
	
			gem.editar(livro);
	}

	@Override
	public List<Livro> listarLivros() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select c from Livro c");
		return query.getResultList();				
		//return gem.getTodosOsLivro();
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
