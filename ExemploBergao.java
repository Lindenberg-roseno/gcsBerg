package com.berg.xxx10;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ExemploBergao extends Activity implements OnClickListener, Runnable {
	private static final String CATEGORIA = "berg";
	private Handler handler = new Handler();
	private ProgressDialog dialog;
	public EditText edt;	
	private  String URL = "";

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		edt = (EditText) findViewById(R.id.editText1);		
		Button b = (Button) findViewById(R.id.buscar);
		b.setOnClickListener(this);
	}

	public void onClick(View view) {		
		dialog = ProgressDialog.show(this, "Exemplo", "Buscando no web service, por favor aguarde...", false, true);
		
		new Thread(this).start();
	}

	public void run() {
		
		final TextView textSoma = (TextView) findViewById(R.id.text);
		
		URL = "http://"+edt.getText().toString().trim()+":8080/ExemploWS/services/TesteWebService?wsdl";
		

		try {
			Bergao bergao = new Bergao(URL);
			
			final String volta = bergao.buscar();
			Object obj =  (Object) volta;
		     obj = obj.toString().replace("[", " ");
		     obj = obj.toString().replace("]", " ");
		     
		     final String[] l = obj.toString().split(",");	
			
			handler.post(new Runnable() {
			
				public void run() {
				textSoma.setTextSize(30);
				
					textSoma.setText(l[0]+" \n"+ l[1]+" \n" 
							+ l[2]+" \n"+ l[3]+" \n");
					     
				
					textSoma.setVisibility(View.VISIBLE);
				
				}
			});
		} catch (Exception e) {
			Log.e(CATEGORIA, e.getMessage(), e);
		} finally {
			dialog.dismiss();
		}
	}
}