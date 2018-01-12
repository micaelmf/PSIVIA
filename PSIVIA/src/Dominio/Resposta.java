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
	
	//método usado no teste
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
						System.out.println("\tNão");
						animaisAux.remove(animal);
					}
				}
			}
			animais = animaisAux;
			i++;
		}
		this.respostas = animais;
		
		if(respostas.size() == 1) {
			System.out.println("---- É um " + getProcurar() + "? ----");
			return this.respostas.get(0).getNome();//
		}
		if(respostas.size() >= 2) {//
			System.out.println("---- É um " + this.respostas.get(0).getNome() + "? ----");
			return this.respostas.get(0).getNome();
		}
		if(respostas.isEmpty() && resposta == null) {//
			System.out.println("---- É um Duiker-zebrado? ----");
			return "Duiker-zebrado";
		}
		return null;
	}
	//método usado na classe Principal
	public String procurarResposta() {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		ArrayList<Animal> animais = daoAnimal.carregaAnimais();
		ArrayList<Animal> animaisAux = new ArrayList<Animal>(animais);
		
		int resp = 0, tamanho = 0;
		for(Pergunta p : perguntas) {
			if(!animaisAux.isEmpty()){
				System.out.println("Pergunta: " + p.getPergunta() + " 1-Sim ou 2-Não\n> ");
				scInt = new Scanner(System.in);
				resp = scInt.nextInt();
				boolean alterou = false;
				if(!animaisAux.isEmpty() && animaisAux != null) {
					for(Animal animal : animais) {
						if(animal.getNome().equals("")) {
							animaisAux.remove(animal);
						}
						Map<String, Boolean> atributos = animal.getAtributos();
						//Se o animal contem a chave
						if(atributos.containsKey(p.getPergunta())) { 
							if(atributos.get(p.getPergunta()) == false) { //se o valor da chave é falso
								animaisAux.remove(animal);							
							}else if(atributos.get(p.getPergunta()) == true && resp == 2) { //o animal tem a chave e a chave é falsa
								animaisAux.remove(animal);							
							}
						}else if(atributos.containsKey(p.getPergunta()) && resp == 1){ //Não tenho a chave mas sou verdadeiro
							animal.setAtributo(p.getPergunta(), true);
							daoAnimal.atualizarAnimal(animal);
							alterou = true;
						}else if(!atributos.containsKey(p.getPergunta()) && resp == 1) {
							animal.setAtributo(p.getPergunta(), false);
							daoAnimal.atualizarAnimal(animal);
							animaisAux.remove(animal);
							alterou = true;
						}
					}
				}
				//carregar animais atualizado que restaram
				if(alterou) {
					ArrayList<Animal> animaisAux2 = new ArrayList<Animal>(animaisAux);
					for(Animal a : animaisAux2) {
						Animal animalAtualizado = daoAnimal.carregaAnimal(a);
						int i = animaisAux.indexOf(a);
						animaisAux.remove(a);
						animaisAux.add(i,animalAtualizado);
					}
					animais = animaisAux;
					
				}
			}
		}
		this.respostas = animaisAux;
		
		if(respostas.size() == 1) {
			return this.respostas.get(0).getNome();
		}
		if(respostas.size() >= 2) {//
			return respostas.get(0).getNome();
		}
		if(respostas.isEmpty() && resposta == null ) {
			return "Tartaruga-de-casco-mole";
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
