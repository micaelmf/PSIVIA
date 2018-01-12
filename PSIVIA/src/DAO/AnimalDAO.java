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
	
	public Boolean gravarAnimal(Animal animal) {
		File diretorio = new File("C:\\PSIVIA18-1"); 
		File arquivo = new File(diretorio, "dados-animais.txt"); 
		
		try {
			if(!arquivo.exists()) {
				arquivo.createNewFile();//cria novo arquivo vazio;
			}
			FileWriter fw = new FileWriter(arquivo,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(animal.getNome() + "|");
			
			ArrayList<String> atributos = new ArrayList<String>();
			atributos = animal.getAtributos();
			for(String atributo : atributos) {
				bw.write(atributo + "|");
			}
		
			bw.newLine();
			bw.close();
			fw.close();
			return true;
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return false;
	}
	
	public void apagarAnimal(Animal animal) {
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-animais.txt");

		try {
	        FileReader fr = new FileReader(arq);
	        BufferedReader br = new BufferedReader(fr);
	        
	        String linha = br.readLine();
	        ArrayList<String> salvar = new ArrayList<>();
	        
	        while(linha != null) {
	        	String[] registro = linha.split(Pattern.quote("|"));
	        	
	        	if(!registro[0].equals(animal.getNome()) ) {
	        		salvar.add(linha);
		        }
	        	
	        	linha = br.readLine();
	        }
	        
	        br.close();
	        fr.close();
	        FileWriter fw2 = new FileWriter(arq,true);
	        fw2.close();
	        
	        FileWriter fw = new FileWriter(arq);
	        BufferedWriter bw = new BufferedWriter(fw);
	        
	        for(String string : salvar) {
	        	bw.write(string);
	        	bw.newLine();
	        }
	        bw.close();
	        fw.close();
		} catch (IOException e) {
	    	//e.printStackTrace();
	    }
	}
	
	public void atualizarAnimal(Animal animal) {
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-animais.txt");

		try {
	        FileReader fr = new FileReader(arq);
	        BufferedReader br = new BufferedReader(fr);
	        
	        String linha = br.readLine();
	        ArrayList<String> salvar = new ArrayList<>();
	        
	        while(linha != null) {
	        	String[] registro = linha.split(Pattern.quote("|"));
	        	
	        	if(!registro[0].equals(animal.getNome()) ) {
	        		salvar.add(linha);
		        }
	        	
	        	linha = br.readLine();
	        }
	        
	        br.close();
	        fr.close();
	        FileWriter fw2 = new FileWriter(arq,true);
	        fw2.close();
	        
	        FileWriter fw = new FileWriter(arq);
	        BufferedWriter bw = new BufferedWriter(fw);
	        
	        for(String string : salvar) {
	        	bw.write(string);
	        	bw.newLine();
	        }
	        bw.close();
	        fw.close();
	        
	        gravarAnimal(animal); //após excluir o animal é adicionado
		} catch (IOException e) {
	    	//e.printStackTrace();
	    }
	}
	
	public Animal carregaAnimal(Animal animal){
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-animais.txt");

	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        Animal a = null;
	        String nomeAnimal = null;
	        ArrayList<String> atributos = new ArrayList<String>();
	        while ((linha = bufferedReader.readLine()) != null) {
	        	String[] registro = linha.split(Pattern.quote("|"));

	        	if(registro[0].equals(animal.getNome())) {
	        		for(int i=0; i < registro.length ;i++) {
		        		if(i == 0) {
		        			nomeAnimal = registro[0];
		        		}else {
	        				atributos.add(registro[i]);
		        		}
		        	}
	        	}
	        }
	        a = new Animal(nomeAnimal,atributos);
	        
	        fileReader.close();
	        bufferedReader.close();
	        return a;
	        
		} catch (IOException e) {
	    	//e.printStackTrace();
	    	return null;
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
	        	ArrayList<String> atributos = new ArrayList<String>();
	        	for(int i=0; i < registro.length ;i++) {
	        		if(i == 0) {
	        			nomeAnimal = registro[0];
	        		}else {
        				atributos.add(registro[i]);
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
	
	public Animal consultarAnimal(Animal animal) {
		File dir = new File("C:\\PSIVIA18-1"); 
		File arq = new File(dir, "dados-animais.txt");

	    try {
	        FileReader fileReader = new FileReader(arq);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        String linha = "";
	        String nomeAnimal = null;
	        ArrayList<String> atributos = new ArrayList<String>();
	        while ((linha = bufferedReader.readLine()) != null) {
	        	String[] registro = linha.split(Pattern.quote("|"));

	        	if(registro[0].equals(animal.getNome())) {
	        		for(int i=0; i < registro.length ;i++) {
		        		if(i == 0) {
		        			nomeAnimal = registro[0];
		        		}else {
	        				atributos.add(registro[i]);
		        		}
		        	}
	        	}
	        }
	        animal = new Animal(nomeAnimal,atributos);
	        
	        fileReader.close();
	        bufferedReader.close();
	        return animal;
	        
		} catch (IOException e) {
	    	//e.printStackTrace();
	    	return null;
	    }
	}
}
