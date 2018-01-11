package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import Dominio.Animal;
import Dominio.Pergunta;

public class PerguntaDAO {
	public void gravarPergunta(Pergunta pergunta) {
		File diretorio = new File("C:\\PSIVIA18-1"); 
		File arquivo = new File(diretorio, "dados-perguntas.txt"); 
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();//cria novo arquivo vazio;
			}
			FileWriter fw = new FileWriter(arquivo,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(pergunta.getPergunta());
			
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
	}
	public ArrayList<Pergunta> carregaPerguntas(){
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-perguntas.txt");

	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	        while ((linha = bufferedReader.readLine()) != null) {
	        	Pergunta pergunta = new Pergunta(linha);
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
