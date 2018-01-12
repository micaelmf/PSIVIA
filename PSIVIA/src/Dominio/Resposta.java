package Dominio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Resposta {
	private String procurar;
	private String resposta;
	private ArrayList<Animal> respostas = new ArrayList<Animal>();
	private static Scanner scInt;
	
	//m�todo usado no teste
	public String procurarResposta(Map<String,Boolean> atributosProcurados) {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		ArrayList<Animal> animais = daoAnimal.carregaAnimais();
		
		int i = 0;
		for(Map.Entry<String, Boolean> entry : atributosProcurados.entrySet()) {
			System.out.println("Pergunta: " + perguntas.get(i).getPergunta());
			ArrayList<Animal> animaisAux = new ArrayList<Animal>(animais);
			for(Animal animal : animais) {
				Map<String, Boolean> atributos = animal.getAtributos();
				if(atributos.containsKey(perguntas.get(i).getPergunta())) {
					if(entry.getValue() == true) {
						System.out.println("\tSim");
					}else {
						System.out.println("\tN�o");
						animaisAux.remove(animal);
					}
				}
			}
			animais = animaisAux;
			i++;
		}
		this.respostas = animais;
		
		if(respostas.size() == 1) {
			System.out.println("---- � um " + getProcurar() + "? ----");
			return this.respostas.get(0).getNome();//
		}
		if(respostas.size() >= 2) {//
			System.out.println("---- � um " + this.respostas.get(0).getNome() + "? ----");
			return this.respostas.get(0).getNome();
		}
		if(respostas.isEmpty() && resposta == null) {//
			System.out.println("---- � um Duiker-zebrado? ----");
			return "Duiker-zebrado";
		}
		return null;
	}
	//m�todo usado na classe Principal
	public String procurarResposta() {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		ArrayList<Animal> animais = daoAnimal.carregaAnimais();
		
		int resp = 0;
		for(Pergunta p : perguntas) {
			System.out.println("Pergunta: " + p.getPergunta() + " 1-Sim ou 2-N�o\n> ");
			scInt = new Scanner(System.in);
			resp = scInt.nextInt();
			ArrayList<Animal> animaisAux = new ArrayList<Animal>();
			if(!animaisAux.isEmpty() && animaisAux != null) {
				animaisAux = new ArrayList<Animal>(animais);
				for(Animal animal : animais) {
					Map<String, Boolean> atributos = animal.getAtributos();
					if(atributos.containsKey(p.getPergunta())) {
						if(resp !=1 ) {
							animaisAux.remove(animal);
						}
					}
				}
			}
			animais = animaisAux;
		}
		this.respostas = animais;
		
		if(respostas.size() == 1) {
			return this.respostas.get(0).getNome();
		}
		if(respostas.size() >= 2) {//
			return this.respostas.get(0).getNome();
		}
		if(respostas.isEmpty() && resposta == null ) {
			return "Duiker-zebrado";
		}
		return null;
	}
	
	
	public String exibirResposta(String animal) {
		return this.procurar;
	}

	public String getProcurar() {
		return procurar;
	}

	public void setProcurar(String procurar) {
		this.procurar = procurar;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(Map<String,Boolean> atributos) {
		this.resposta = procurarResposta(atributos);
	}
	public void setResposta() {
		this.resposta = procurarResposta();
	}
	
}
