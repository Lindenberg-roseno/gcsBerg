package com.berg.xxx10;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;


public class BergaoHttpTransport extends HttpTransportSE {
	private static final String CATEGORIA = "bergao";

	public BergaoHttpTransport(String s) {
		super(s);
	}

	@Override
	public void call(String s, SoapEnvelope soapenvelope) throws IOException, XmlPullParserException {
		// Aapenas para logar o xml elemento envelope do SOAP
		
		byte bytes[] = createRequestData(soapenvelope);
		
		String envelope = new String(bytes);
		
		Log.i(CATEGORIA, "berg Envelope: " + envelope.toString());

		super.call(s, soapenvelope);
		
	}
}
