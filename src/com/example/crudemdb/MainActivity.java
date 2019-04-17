package com.example.crudemdb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	public EditText nome, pwd;
	public Button enviar, listar;
	public SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		criarOuAbrirBanco();
		criarComponentes();
		acaoDeBotao();
		
	}
	
	
	public void criarOuAbrirBanco() {
		// TODO Auto-generated method stub
		db = openOrCreateDatabase("biblioteca", 0, null);

		if (db != null) {

			CriarDb banco = new CriarDb(getApplicationContext(), "biblioteca",
					null, 1);
			banco.setDb(db);
			banco.onCreate(db);
		}
	}

	public void acaoDeBotao() {

		enviar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cadastrar();
			}
		});

		listar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listagem();
			}
		});
	}

	public void criarComponentes() {
		nome = (EditText) findViewById(R.id.nome);
		pwd = (EditText) findViewById(R.id.pwd);
		enviar = (Button) findViewById(R.id.enviar);
		listar = (Button) findViewById(R.id.Listar);
	}

	public void cadastrar() {
		
		Livros livro = new Livros(nome.getText().toString(),"321564","QQ coisa",pwd.getText().toString());		
		RepositorioLivrosSQLite rep = new RepositorioLivrosSQLite();
		rep.openDB(db);
		rep.cadastrarLivros(livro);		

	}

	public void listagem() {
		Intent it = new Intent(getApplicationContext(), ListaActivity.class);
		startActivity(it);
	}
}
