package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PerguntaDAO {
	public void gravarPergunta(String pergunta) {
		File diretorio = new File("C:\\PSIVIA18-1"); 
		File arquivo = new File(diretorio, "dados-perguntas.txt"); 
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();//cria novo arquivo vazio;
			}
			FileWriter fw = new FileWriter(arquivo,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(pergunta);
			
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
	}
	public ArrayList<String> carregaPerguntas(){
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-perguntas.txt");
		ArrayList<String> perguntas = new ArrayList<String>();
		
	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        while ((linha = bufferedReader.readLine()) != null) {
	        	String pergunta = linha;
	        	perguntas.add(pergunta);
        	}
	        
	        fileReader.close();
	        bufferedReader.close();
	        
	        return perguntas;
	        
		} catch (IOException e) {
	    	//e.printStackTrace();
	    	return null;
	    }
	}
}
