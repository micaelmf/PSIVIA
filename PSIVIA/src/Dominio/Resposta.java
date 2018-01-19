package Dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sun.scenario.animation.AnimationPulseMBean;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Resposta {
	Animal ultimoRemovido = new Animal();
	Map<String,Boolean> novosAtributos = new LinkedHashMap<String,Boolean>();
	boolean seguir = true;
	
	public String responder() {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		AnimalDAO daoAnimal = new AnimalDAO();
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		ArrayList<String> perguntasFeitas = new ArrayList<>();
		ArrayList<Animal> animais = daoAnimal.carregarAnimais();
		ArrayList<Animal> animaisAux = new ArrayList<Animal>(animais);
		Scanner scan = new Scanner(System.in);

		for(int i = 0; i < animais.size(); i++) {
			Animal animal = animais.get(i);
			if(animaisAux.contains(animal)) {
				for(String pergunta : perguntas) {
					Map<String,Boolean> ss = animal.getAtributos();
					int resposta = 0;
					if(ss.containsKey(pergunta) && !perguntasFeitas.contains(pergunta)) {
						perguntasFeitas.add(pergunta);
						System.out.println(pergunta + "?");
						resposta = scan.nextInt();
						animaisAux = retornarOsVerdadeiros(animais,pergunta,resposta);
						
					}else if(ss.isEmpty() && animais.contains(animal)){
						System.out.println(animal.getNome() + "" + pergunta + " Decartado (fora)");
						animais.remove(animal);
						ultimoRemovido = animal;
					}
				}
			}
			if(animais.size() == 1) {
				return animais.get(0).getNome();
			}
		}
		if(animais.isEmpty()) {
			return this.ultimoRemovido.getNome();
		}else {
			return animais.get(0).getNome();
		}
		
//		//int i = 0;
//		while(i < animais.size()) {
//			Animal animal = animais.get(i);
//			for(String pergunta : perguntas) {
//				Map<String,Boolean> ss = animal.getAtributo(pergunta);
//				int resposta = 0;
//				if(!ss.isEmpty() && ss != null 
//						&& !perguntasFeitas.contains(pergunta) && ss.get(pergunta) != false) {
//					
//					perguntasFeitas.add(pergunta);
//					System.out.println(pergunta + "?");
//					resposta = scan.nextInt();
//					
//					animais = retornarOsVerdadeiros(animais,pergunta,resposta);
//				}
//			}
//			if(seguir) {
//				i++;
//			}
//			if(animais.size() == 1) {
//				return animais.get(0).getNome();
//			}
//		}
//		if(animais.isEmpty()) {
//			return this.ultimoRemovido.getNome();
//		}else {
//			return animais.get(0).getNome();
//		}
	}

	public ArrayList<Animal> retornarOsVerdadeiros(ArrayList<Animal> animais, String pergunta, int resposta) {
		int j = 0, tamanho = animais.size();
		boolean add = true, atualizar = false;
		
		while(j < animais.size()) {

			Animal proxAnimal = animais.get(j);
			Map<String,Boolean> kk = proxAnimal.getAtributos();
			System.out.print(proxAnimal.getNome() + " " + pergunta);
			/*
			 * se a resposta é 1 - remover animais que contenham a chave e que o valor seja falso
			 * se a resposta é 2 - remover animais que contenham a chave e que o valor seja true
			 */
			if(!kk.isEmpty() && kk != null) {
				if(resposta == 1 && kk.get(pergunta) == false) {
					System.out.println(" Decartado 1");
					animais.remove(proxAnimal);
					ultimoRemovido = proxAnimal;
					tamanho--;
					add = false;
					
				}else if(resposta == 2 && kk.get(pergunta) == true) {
					System.out.println(" Decartado 2");
					animais.remove(proxAnimal);
					ultimoRemovido = proxAnimal;
					tamanho--;
					add = false;
				}else if((resposta == 1 && kk.get(pergunta) == true)) {
					System.out.println(" Mantido 1");
					add = true;
				}else if((resposta == 2 && kk.get(pergunta) == false)){
					System.out.println(" Mantido 2");
					add = true;
				}else{
					System.out.println(" Mantido 3");
					add = true;
				}
			}else {
				if(resposta == 2) {
					System.out.println(" Decartado 3");
					animais.remove(proxAnimal);
					ultimoRemovido = proxAnimal;
					tamanho--;
					add = false;
				}else if(resposta == 2) {
					System.out.println("Manter 4");
					add = true;
//					animais.remove(proxAnimal);
//					ultimoRemovido = proxAnimal;
//					add = false;
//					this.seguir = false;
				}else {
					System.out.println("Como assim?!?!?!?!");
				}
			}
			if(add) {
				j++;
			}
		}
		if(tamanho == animais.size()) {
			this.seguir = true;
		}else {
			this.seguir = false;
		}
		return animais;
	}
//	public Map<String, List<String>> classificarAnimais() {
//		AnimalDAO daoAnimal = new AnimalDAO();
//		PerguntaDAO daoPergunta = new PerguntaDAO();
//		
//		ArrayList<Animal> animais = daoAnimal.carregarAnimais();
//		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
//		
//		//String[][] matriz = new String[perguntas.size()][2];
//		Map<String, List<String>> matriz = new LinkedHashMap<>();
//
//		for(String pergunta: perguntas) {
//			ArrayList<String> classificados = new ArrayList<String>();
//			Map<String, Boolean> atributo = new LinkedHashMap<>();
//			for(Animal animal : animais) {
//				atributo = animal.getAtributo(pergunta);
//				System.out.println(!atributo.isEmpty() || !atributo.equals(null));
//				if(!atributo.isEmpty() && !atributo.equals(null)) {
//					if(atributo.get(pergunta) == true) {
//						classificados.add(animal.getNome());
//					}
//				}
//			}
//			matriz.put(pergunta, classificados);
//		}
//		
//		return matriz;
		
		//imprimirClassificados(matriz);
		
		//		int i = 0;
//		int j = 0;
//		for(String pergunta: perguntas) {
//			//ArrayList<String> classificados = new ArrayList<String>();
//			Map<String, Boolean> atributo = new LinkedHashMap<>();
//			for(Animal animal : animais) {
//				atributo = animal.getAtributo(pergunta);
//				if(!atributo.isEmpty() && atributo != null) {
//					matriz[i][j] = pergunta;
//					j++;
//				}
//			}
//			i++;
//		}
		
//		for(Animal animal : animais) {
//			animal.getAtributo(chave);
//		}
//	}
	
	public void imprimirClassificados(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println(matriz[i][j]);
			}
		}
	}

	public Map<String, Boolean> getNovosAtributos() {
		return novosAtributos;
	}

	public void setNovosAtributos(Map<String, Boolean> novosAtributos) {
		this.novosAtributos = novosAtributos;
	}
	

