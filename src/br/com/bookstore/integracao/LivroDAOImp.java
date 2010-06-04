package br.com.bookstore.integracao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroDao.class)
public class LivroDAOImp implements LivroDao {

	@PersistenceContext(name="BookStoreLivro")
	private EntityManager em;	
	
	public void deleteLivro(Livro livro) throws Exception {
		em.remove(em.find(Livro.class, livro.getId()));		
	}

	@Override
	public Livro getLivro(String isbn) throws Exception {
		 Livro l = null;
		Query query = em.createQuery("select c from Livro c where c.isbn =?1");
		query.setParameter(1, isbn);
		try {
		  l = (Livro) query.getSingleResult();
		} catch (NoResultException e) {
			l = null;
		} 
		return l;	
	}

	@Override
	public void insertLivro(Livro livro){
			em.persist(livro);				
	}

	@Override
	public ArrayList<Livro> searchLivro(String dado) throws Exception {
		List<Livro> resultado = null;
			Query query = em.createQuery("select c from Livro c where upper(c.titulo) like  ?1 or upper(c.isbn) like  ?2 or upper(c.autor) like  ?3 ");
			query.setParameter(1, "%" + dado.toUpperCase() + "%");
			query.setParameter(2, "%" + dado.toUpperCase() + "%");
			query.setParameter(3, "%" + dado.toUpperCase() + "%");
			try {
				resultado = query.getResultList();
			} catch (NoResultException e) {
				resultado = null;
			} 
			return (ArrayList<Livro>) resultado;	
	}

	@Override
	public List<Livro> selectLivros() {
		Query query = em.createQuery("select c from Livro c");
		List<Livro> resultList = query.getResultList();
		return resultList;	
	}

	@Override
	public void updateLivro(Livro livro){
			em.merge(livro);			
	}

}
