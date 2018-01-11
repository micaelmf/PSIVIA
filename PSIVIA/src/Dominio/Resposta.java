package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Resposta {
	private String procurar;
	private String resposta;
	private ArrayList<Animal> respostas = new ArrayList<Animal>();
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	
	public String procurarResposta(Map<String,Boolean> atributosProcurados) {
		ArrayList<Animal> animais = new ArrayList<Animal>();
		Pergunta p1 = new Pergunta("Tem rabo?");
		perguntas.add(p1);
		Pergunta p2 = new Pergunta("Tem 4 patas?");
		perguntas.add(p2);
		Pergunta p3 = new Pergunta("Tem pêlos?");
		perguntas.add(p3);
		Pergunta p4 = new Pergunta("Ele late?");
		perguntas.add(p4);
		Pergunta p5 = new Pergunta("Ele mia?");
		perguntas.add(p5);
		
		
		Map<String,Boolean> atributos1 = new LinkedHashMap<>();
		atributos1.put(p1.getPergunta(), true);
		atributos1.put(p2.getPergunta(), true);
		atributos1.put(p3.getPergunta(), true);
		atributos1.put(p4.getPergunta(), true);
		Animal a1 = new Animal("Cachorro", atributos1);		
		animais.add(a1);
		
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		atributos2.put(p1.getPergunta(), true);
		atributos2.put(p2.getPergunta(), true);
		atributos2.put(p3.getPergunta(), true);
		atributos2.put(p5.getPergunta(), true);
		Animal a2 = new Animal("Gato", atributos2);
		animais.add(a2);
		
		this.respostas = animais;
		int i = 0;
		for(Map.Entry<String, Boolean> entry : atributosProcurados.entrySet()) {
			for(Animal animal : this.respostas) {
				System.out.println("Chave - Valor: " + entry.getKey() + entry.getValue());
				System.out.println("Pergunta: " + perguntas.get(i).getPergunta());
				Map<String, Boolean> atributos = animal.getAtributos();
				if(atributos.containsKey(perguntas.get(i).getPergunta())) {
					if(entry.getValue() == true) {
						System.out.println("\tSim");
					}else {
						this.respostas.remove(animal);
					}
					if(respostas.size() == 1) {
						System.out.println("---- É um " + getProcurar() + "? ----");
						//setResposta(this.respostas.get(0));
						return this.respostas.get(0).getNome();
					}
				}
			}
					
			i++;
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
