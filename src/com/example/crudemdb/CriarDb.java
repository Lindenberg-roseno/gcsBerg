package com.example.crudemdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CriarDb extends SQLiteOpenHelper {

	public int newVersion;
	public SQLiteDatabase db;
	public String path;
	public String script;
	public Context ctx;
	public String name;

	public CriarDb(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub

		this.newVersion = version;
	}

	public int getNewVersion() {
		return newVersion;
	}

	public void setNewVersion(int newVersion) {
		this.newVersion = newVersion;
	}

	public SQLiteDatabase getDb() {
		return db;
	}

	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String LIVROS = "CREATE TABLE IF NOT EXISTS livros ("
			+ "id_livros INTEGER(11)," 
			+ "autor TEXT(50),"
			+ "editora TEXT(50),"
			+ "isbn TEXT(50),"
			+ "titulo TEXT(50),"
			+ "PRIMARY KEY(id_livros));";

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		try {
			
			this.db = db;			
			this.db.execSQL(LIVROS);
			this.db.setVersion(this.newVersion);

			Log.i("berg", "cria tabela com sucesso ");
			
		} catch (NullPointerException e) {
			// TODO: handle exception
			Log.i("berg", "error no oncreate banco linha 60 " + e);
		}

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		try {

			this.db = db;
			this.newVersion = newVersion;

			if (oldVersion < this.newVersion) {

				/*
				 * this.db.execSQL("drop table if exists CLIENTE;");
				 * this.db.execSQL("drop table if exists MUNICIPIO;");
				 * this.db.execSQL("drop table if exists UF;");
				 */
				// //db.execSQL("alter table ocorrencias_visitas RENAME TO old_ocorrencias_visitas_"+oldVersion);
				// this.db.execSQL(this.CLIENTE);///recriando a tabela vazia
				// /db.execSQL("insert into ocorrencias_visitas select * from old_ocorrencias_visitas_"+oldVersion);
			}

			this.db.setVersion(this.newVersion);

		} catch (NullPointerException e) {
			// TODO: handle exception
			Log.i("berg", "error no onUpgrade banco " + e);
		}

	}

}
