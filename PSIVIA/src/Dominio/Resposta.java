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
	private Map<String, Boolean> novosAtributos = new LinkedHashMap<>();
	
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
		boolean alterou = false;
		
		
		for(Pergunta p : perguntas) {
			boolean novoAtributo = true;
			if(!animaisAux.isEmpty()){
				System.out.println("Pergunta: " + p.getPergunta() + " 1-Sim ou 2-Não\n> ");
				scInt = new Scanner(System.in);
				resp = scInt.nextInt();
				if(!animaisAux.isEmpty() && animaisAux != null) {
					for(Animal animal : animais) {
						ArrayList<Animal> animaisAux2 = new ArrayList<Animal>(animaisAux);
						if(animal.getNome().equals("")) {
							animaisAux.remove(animal);
						}
						Map<String, Boolean> atributos = animal.getAtributos();
						//Se o animal contem a chave o valor é verdadeiro
						if(atributos.containsKey(p.getPergunta()) && resp == 1) {
							if(novoAtributo && resp == 1) {
								this.novosAtributos.put(p.getPergunta(), true);
								novoAtributo = false;
							}
							if(atributos.containsKey(p.getPergunta()) == true && resp == 2) {
								animaisAux2.remove(animal);
							}
						}else if(!atributos.containsKey(p.getPergunta()) && resp == 1) { //se o animal não tem a chave a resposta é verdadeira
							if(novoAtributo && resp == 1) {
								this.novosAtributos.put(p.getPergunta(), true);
								novoAtributo = false;
							}
							animaisAux2.remove(animal);
							alterou = true;
//							animal.setAtributo(p.getPergunta(), true);
//							daoAnimal.atualizarAnimal(animal);
//							alterou = true;
						
						}else if(!atributos.containsKey(p.getPergunta()) && resp == 2) {
							if(novoAtributo && resp == 1) {
								this.novosAtributos.put(p.getPergunta(), true);
								novoAtributo = false;
							}
						}else if(atributos.containsKey(p.getPergunta()) && resp == 2) {
							animaisAux2.remove(animal);
							alterou = true;							
						}
						animaisAux = animaisAux2;
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
				this.respostas = animaisAux;
				if(respostas.size() == 1) {
					return this.respostas.get(0).getNome();
				}
			}
		}
		this.respostas = animaisAux;
		
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
	public Map<String, Boolean> getNovosAtributos() {
		return novosAtributos;
	}
	public void setNovosAtributos(Map<String, Boolean> novosAtributos) {
		this.novosAtributos = novosAtributos;
	}
	
}
