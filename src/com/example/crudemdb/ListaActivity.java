package com.example.crudemdb;

import java.util.ArrayList;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ListaActivity extends Activity {
	public TextView Lista1;
	public SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);

		db = openOrCreateDatabase("biblioteca", 0, null);

		Lista1 = (TextView) findViewById(R.id.Lista1);
		try {
			RepositorioLivrosSQLite rep = new RepositorioLivrosSQLite();
			rep.openDB(db);
			ArrayList<Livros> l = rep.getAllLivros();
			/*RepositorioLivrosSQLite.getInstance().openDB(db);
			ArrayList<Livros> l = RepositorioLivrosSQLite.getInstance()
					.getAllLivros();
			 */
			for (int i = 0; i <= l.size()-1; i++) {
				
				Lista1.setText(l.get(i).getsAutor().toString() + "-"
						+ l.get(i).getsISBN().toString() + "-"
						+ l.get(i).getsTitulo().toString() + "-"
						+ l.get(i).getsEditora().toString()+" \n");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
