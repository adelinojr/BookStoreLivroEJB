package br.com.bookstore.model.livro;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.bookstore.model.exceptions.LivroException;

public class GenrenciadorLivro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Livro> livros;
		
	public GenrenciadorLivro( ) {
	}
	
	public void persist( Livro livro ) throws LivroException{
		if(isLivro(livro)){
			this.livros.add(livro); 	
		}else{
			throw new LivroException("Livro já existe");
		}
	}	
	public void remove(Livro livro) throws LivroException{
	    if( !isLivro(livro)) {	
	    	this.livros.remove(livro);
	    }else{
	    	throw new LivroException("Livro não existe");
	    }
	    
	}
	
	public void editar(Livro livro) throws LivroException{
		if( getLivro(livro.getIsbn()) != null){
			this.livros.set(getIndexLivro(livro.getIsbn()),livro);
		}else{
			throw new LivroException("alteração não permitida");
		}
		
		
	}
	
	public List<Livro> getTodosOsLivro(){

		return null;
	}

	public Livro getLivro(String isbn){
		Livro livroRecebido = null;
		for ( int i = 0; i < this.livros.size(); i++ ){		
			if ( this.livros.get(i).getIsbn().equals(isbn) ){
			   livroRecebido = this.livros.get(i);
			   break;
			}
		}		
		return livroRecebido;
	}

	public int getIndexLivro(String isbn){
		for ( int i = 0; i < livros.size(); i++ ){ 
			if ( this.livros.get(i).getIsbn().equals(isbn) ){
				return i;
			}
		}		
		
		return -1;
		
	}
	
	private boolean  isLivro(Livro livro){
		   boolean b = true;
		    for (Livro l : livros) {
			  if( livro.getIsbn().equals(l.getIsbn())){
				  b = false;
			  }		  
			}
		   return b;
	}
		

	public ArrayList<Livro> CriarLivros(){
		ArrayList<Livro> lista = new ArrayList<Livro>();
		Livro l1 = new Livro();
		l1.setId(1);
		l1.setTitulo("EJB: Livro de Receitas");
		l1.setAutor("BENJAMIM G. SULLINS & MARK B. WHIPPLE");
		l1.setEditora("Ciência Moderna");
		l1.setEdicao(1);
		l1.setAno(2004);
		l1.setNumeroDePaginas(328);
		l1.setIsbn("8573933372");
		l1.setResenha("EJB: Livro de Receitas é uma coleção sistemática de soluções para problemas " +
					  "práticos de desenvolvimento de EJB. aplicar soluções imediatas.");
	    l1.setCategoria(Genero.Informatica);
	    l1.setPreco(new BigInteger("150"));
		lista.add(l1);
		
		Livro l2 = new Livro();
		l2.setId(2);
		l2.setTitulo("Construindo Sites com CSS e (X)HTML");
		l2.setAutor("MAURICIO SAMY SILVA");
		l2.setEditora("Novatec");
		l2.setEdicao(1);
		l2.setAno(2007);
		l2.setNumeroDePaginas(448);
		l2.setIsbn("9788575221396");
		l2.setResenha("As CSS são uma" +
					  "poderosa ferramenta à disposição do desenvolvedor para criar um arquivo central de controle de todo o layout e " +
					  "apresentação do site. ");		
		l2.setCategoria(Genero.Informatica);
		l2.setPreco(new BigInteger("98"));
		lista.add(l2);
		
		Livro l3 = new Livro();
		l3.setId(3);
		l3.setTitulo("Use a Cabeça! Java");
		l3.setAutor("KATHY SIERRA & BERT BATES");
		l3.setEditora("Alta Books ");
		l3.setEdicao(2);
		l3.setAno(2007);
		l3.setNumeroDePaginas(496);
		l3.setIsbn("9788576081739");
		l3.setResenha("Se o seu intuito é ficar entediado, compre outro livro. Mas se quiser realmente aprender Java, " +
					"você precisa de Use a Cabeça Java. Descubra por que os livros da série se a Cabeça foram selecionados " +
					"para o Amazon Editor Choice que indicou os dez melhores livros de computação de 2003 e 2004.");		
		l3.setCategoria(Genero.Informatica);
		l3.setPreco(new BigInteger("116"));
		lista.add(l3);
	
		Livro l4 = new Livro();
		l4.setId(4);
		l4.setTitulo("JavaServer Faces 2.0, The Complete Reference");
		l4.setAutor("Ed Burns & Neil Griffin ");
		l4.setEditora("McGraw-Hill Osborne Media");
		l4.setEdicao(1);
		l4.setAno(2009);
		l4.setNumeroDePaginas(752 );
		l4.setIsbn("0071625097");
		l4.setResenha("Fully revised and updated for all of the changes in JavaServer Faces (JSF) 2.0, this comprehensive volume " +
					  "covers every aspect of the official standard Web development architecture for JavaEE. ");		
		l4.setCategoria(Genero.Informatica);
		l4.setPreco(new BigInteger("214"));
		lista.add(l4);
		
		return lista;
	}
	
	public ArrayList<Livro> buscarLivro(String nome) throws LivroException{
		ArrayList<Livro> livrosBusca = new ArrayList<Livro>();
		if (nome != null &&  !nome.isEmpty()) {
			for (Livro livro : this.livros) {
				if (livro.getTitulo().toUpperCase().contains(nome.toUpperCase())) {
					livrosBusca.add(livro);
				} else if (livro.getAutor().toUpperCase().contains(nome.toUpperCase())) {
					livrosBusca.add(livro);
				} else if (livro.getResenha().toUpperCase().contains(nome.toUpperCase())) {

					livrosBusca.add(livro);
				}
			}
		  if(livrosBusca.size() == 0){
			  throw new LivroException("Livro não encontrado");
		  }
		}else{
			throw new LivroException("Livro não encontrado");
		}
		return livrosBusca;
	}	
}
