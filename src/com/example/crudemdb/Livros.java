package com.example.crudemdb;

import java.io.Serializable;

public class Livros implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1900762229366168098L;
	
	public int id_livro;
	public String sTitulo;
	public String sISBN;
	public String sAutor;
	public String sEditora;
 
		public Livros(){
			
		}

		public Livros(String sTitulo, String sISBN, String sAutor,
				String sEditora) {
			super();
			this.sTitulo = sTitulo;
			this.sISBN = sISBN;
			this.sAutor = sAutor;
			this.sEditora = sEditora;
		}

		
		
		public int getId_livro() {
			return id_livro;
		}

		public void setId_livro(int id_livro) {
			this.id_livro = id_livro;
		}

		public String getsTitulo() {
			return sTitulo;
		}

		public void setsTitulo(String sTitulo) {
			this.sTitulo = sTitulo;
		}

		public String getsISBN() {
			return sISBN;
		}

		public void setsISBN(String sISBN) {
			this.sISBN = sISBN;
		}

		public String getsAutor() {
			return sAutor;
		}

		public void setsAutor(String sAutor) {
			this.sAutor = sAutor;
		}

		public String getsEditora() {
			return sEditora;
		}

		public void setsEditora(String sEditora) {
			this.sEditora = sEditora;
		}
 
	
	
}
