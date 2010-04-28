package br.com.bookstore.integracao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroDao.class)
public class LivroDAOImp implements LivroDao {

	@PersistenceContext(name="BookStoreLivro")
	private EntityManager em;	
	
	public void deleteLivro(Livro livro) throws LivroException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Livro getLivro(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertLivro(Livro livro) throws LivroException {
		em.persist(livro);
		
	}

	@Override
	public ArrayList<Livro> searchLivro(String dado) throws LivroException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livro> selectLivros() {
		Query query = em.createQuery("select c from Livro c");
		return query.getResultList();	
	}

	@Override
	public void updateLivro(Livro livro) throws LivroException {
		// TODO Auto-generated method stub
		
	}

}
