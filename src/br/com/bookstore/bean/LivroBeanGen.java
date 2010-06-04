package br.com.bookstore.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.bookstore.integracao.LivroDao;
import br.com.bookstore.model.exceptions.LivroException;
import br.com.bookstore.model.livro.Livro;

@Stateless
@Local(LivroBeanModel.class)
public class LivroBeanGen implements LivroBeanModel {

	@EJB(name="BookStoreLivroEJB/LivroDAOImp",beanInterface=LivroDao.class)
	private LivroDao em;
	
	public LivroBeanGen (){
	}
	
	@Override
	public ArrayList<Livro> buscaLivro(String dado) throws LivroException {
		try {
			return em.searchLivro(dado);
		} catch (Exception e) {
			throw new LivroException("Livro não encontrado");
		}
	}

	@Override
	public void cadastrarLivro(Livro livro) throws LivroException {
		   try {
			if(this.isLivro(em.getLivro(livro.getIsbn()))){
				em.insertLivro(livro);
			   }else{
				   throw new LivroException("Livro já existe");
			   }
		} catch (Exception e) {
			throw new LivroException("Entre em contato com Administrador- ERRO 0037");
		}
			   
	}

	@Override
	public void editarLivro(Livro livro) throws LivroException {
		 try {
			if(!this.isLivro(em.getLivro(livro.getIsbn()))){
				 em.updateLivro(livro);
			 }else{
				 throw new LivroException("Livro Não Existe");
			 }
		} catch (Exception e) {
			throw new LivroException("Entre em contato com Administrador- ERRO 0039");
		}
			
	}

	@Override
	public List<Livro> listarLivros() {		
		return em.selectLivros();
	}

	@Override
	public Livro obterLivro(String isbn) throws LivroException {
		try {
			return em.getLivro(isbn);
		} catch (Exception e) {
			throw new LivroException("Entre em contato com Administrador- ERRO 0031");
		}
	}

	@Override
	public void removerLivro(Livro livro) throws LivroException {
		try {
			em.deleteLivro(livro);
		} catch (Exception e) {
			throw new LivroException("Entre em contato com Administrador- ERRO 0032");
		}
	}		

	private boolean isLivro( Livro livro ){
		 boolean result = true;
		 if(livro != null){
			 result = false;
		 }
		return result;
	}	
}
