package br.com.bookstore.model.livro;

import java.io.Serializable;

/**
 * Enumeration para definir a categoria, ou seja, o gênero
 * no qual se encaixa um determinado livro.
 * 
 * @author Adelino Ferreira - bugass@gmail.com
 */
public enum Genero  implements Serializable  {
	AutoAjuda,
	AdministracaoENegocios,
	Artes,
	CienciasExatas,
	Culinaria,
	Direito,
	Economia,
	Esportes,
	Filosofia,
	Informatica,
	Linguistica,
	Psicologia,
	Religiao;
	
}
