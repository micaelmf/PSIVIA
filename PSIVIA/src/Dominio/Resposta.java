package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Resposta {
	private String procurar;
	private String resposta;
	private ArrayList<Animal> respostas = new ArrayList<Animal>();
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	
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
	
}
