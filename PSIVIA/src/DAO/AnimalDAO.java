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

public class AnimalDAO {
	
	public void gravarAnimal(Animal animal) {
		File diretorio = new File("C:\\PSIVIA18-1"); 
		File arquivo = new File(diretorio, "dados-animais.txt"); 
		//System.out.println(arq.getAbsolutePath()); //recupera o local do arquivo
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();//cria novo arquivo vazio;
			}
			FileWriter fw = new FileWriter(arquivo,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(animal.getNome() + "|");
			
			Map<String,Boolean> atributos = new LinkedHashMap<>();
			atributos = animal.getAtributos();
			for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
				bw.write(atributo.getKey() + "-" + atributo.getValue() + "|");
			}
		
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
		    e.printStackTrace(); 
		}
	}
	
	public ArrayList<Animal> carregaAnimais(){
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-animais.txt");

	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        ArrayList<Animal> animais = new ArrayList<Animal>();
	        while ((linha = bufferedReader.readLine()) != null) {
	        	String[] registro = linha.split(Pattern.quote("|"));

	        	String nomeAnimal = null;
	        	Map<String,Boolean> atributos = new LinkedHashMap<>();
	        	for(int i=0; i < registro.length ;i++) {
	        		if(i == 0) {
	        			nomeAnimal = registro[0];
	        		}else {
	        			String atributosString = registro[i];
	        			String[] chaveValor = atributosString.split(Pattern.quote("-"));
	        			String chave = chaveValor[0];
	        			boolean valor = Boolean.parseBoolean(chaveValor[1]);
	        			
        				atributos.put(chave,valor);
	        		}
	        	}
	        	Animal animal = new Animal(nomeAnimal,atributos);
	        	animais.add(animal);
	        }
	        
	        fileReader.close();
	        bufferedReader.close();
	        return animais;
	        
		} catch (IOException e) {
	    	//e.printStackTrace();
	    	return null;
	    }
	}
}
