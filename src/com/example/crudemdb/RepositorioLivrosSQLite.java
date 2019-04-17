package com.example.crudemdb;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RepositorioLivrosSQLite {

	private static RepositorioLivrosSQLite instance;
	public static final String NOME_TABELA = "livros";	
	public SQLiteDatabase db;
	
	public static RepositorioLivrosSQLite getInstance()
			throws  Exception {
		if (instance == null) {
			instance = new RepositorioLivrosSQLite();
		}
		return instance;
	}
	
	public void openDB(SQLiteDatabase db)  {
		// TODO Auto-generated method stub
		this.db = db;
	}

	public void closeConnection() {
		if (db != null) {
			try {
				db.close();
				
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

	public void cadastrarLivros(Livros livro)  {
	
			
	    ContentValues p_valores = new ContentValues();		
		p_valores.put("autor", livro.getsAutor());		
		p_valores.put("editora", livro.getsEditora());
		p_valores.put("isbn", ""+livro.getsISBN());
		p_valores.put("titulo", livro.getsTitulo());
		
			
		try {
			if (db != null) {

				db.insert(NOME_TABELA, null, p_valores);
				
			} else {

			}
			
		} catch (NullPointerException e) {
		}
	}

	public ArrayList<Livros> getAllLivros() {
		// TODO Auto-generated method stub
		
		Cursor rs = null;
		
		ArrayList<Livros> livros= null;
		
		try {
			
			livros = new ArrayList<Livros>();	
			
			String sql = "Select * from "+NOME_TABELA;		
			
			rs = this.db.rawQuery(sql, null);
	
			rs.moveToFirst();
			
			if (rs.getCount() > 0 && rs != null) {
				
				do {
					
					Livros livro = new Livros();			
				///	livro.setId_livro(Integer.parseInt(rs.getString((rs.getColumnIndex("id_livros")))));
					livro.setsAutor(rs.getString((rs.getColumnIndex("autor"))));					
					livro.setsEditora(rs.getString((rs.getColumnIndex("editora"))));
					livro.setsISBN(rs.getString((rs.getColumnIndex("isbn"))));		
					livro.setsTitulo(rs.getString((rs.getColumnIndex("titulo"))));					
					
					livros.add(livro);
					
				} while (rs.moveToNext());
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		
		return livros;
		
	}
	public void deletarLivros(int id) {
		// TODO Auto-generated method stub
		String where =  " id =?";		
		db.delete(NOME_TABELA, where, null);
	}
	
	public void alterarLivros(Livros livro){
		// TODO Auto-generated method stub
		ContentValues p_valores = new ContentValues();
		p_valores.put("autor", livro.getsAutor());	
		p_valores.put("editora", livro.getsEditora());
		p_valores.put("isbn", livro.getsISBN());
		p_valores.put("titulo", livro.getsTitulo());
		
		String where = "id_livro =?";		

		db.update(NOME_TABELA, p_valores, where, null);

	
	}	
	
}
