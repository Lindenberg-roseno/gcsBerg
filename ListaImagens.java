package com.berg.xxx10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;


public class ListaImagens {
	
	public  int[] imagens;
	public Object[] img;
	public String path;
	public FileInputStream arquivoLeitura;
	public Object[] o;
	public ObjectInputStream objLeitura;
	
	public ListaImagens() {
		
	}
	
	public  void le() throws StreamCorruptedException, IOException, ClassNotFoundException {
		 //Carrega o arquivo  
		
        ///for(int i=0;i < 10;i++){
		try {
		
			//arquivoLeitura = new FileInputStream(path+"page_"+i+".png");
			arquivoLeitura = new FileInputStream("C:/Users/IDEIA/Desktop/"+"xx");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		//Classe responsavel por recuperar os objetos do arquivo  
        objLeitura = new ObjectInputStream(arquivoLeitura);  
        System.out.println(objLeitura.readObject());  
        objLeitura.close();  
        arquivoLeitura.close();  
    //    }
        
        ///return o;
	}


}
