package com.berg.xxx10;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;


public class Bergao {
	private static final String TAG = "berg";
	private final String url;
	
	public Bergao(String url) {
		this.url = url;
	}
	public String buscar() throws IOException, XmlPullParserException {
		// Namespace e nome para o objeto SOAP
		SoapObject soap = new SoapObject("http://exemplowebservice.br.com", "getAllClientes");	

		// Cria o envelope com o objeto SOAP
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(soap);

		Log.i(TAG, "Chamando WebService: " + url);

		// Cria o HttpTransport para enviar os dados (SOAP)
		HttpTransportSE httpTransport = new BergaoHttpTransport(url);

		// Faz a requisição
		httpTransport.call("", envelope);
		
		// Recupera o resultado
		Object voltando = (Object) envelope.getResponse();

		return voltando.toString();
	}
}
