package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Resposta {
	private String procurar;
	private Animal resposta;
	private ArrayList<Animal> respostas = new ArrayList<Animal>();
	private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	
	public void procurarResposta() {
		ArrayList<Animal> animais = new ArrayList<Animal>();
		Map<String,Boolean> atributos1 = new HashMap<>();
		Pergunta p1 = new Pergunta("Tem rabo?");
		perguntas.add(p1);
		Pergunta p2 = new Pergunta("Tem 4 patas?");
		perguntas.add(p2);
		Pergunta p3 = new Pergunta("Tem pêlos?");
		perguntas.add(p3);
		Pergunta p4 = new Pergunta("Ele late?");
		perguntas.add(p4);
		atributos1.put(p1.getPergunta(), true);
		atributos1.put(p2.getPergunta(), true);
		atributos1.put(p3.getPergunta(), true);
		atributos1.put(p4.getPergunta(), true);
		Animal a1 = new Animal("Cachorro", atributos1);		
		animais.add(a1);
		
		
		for(Pergunta pergunta : perguntas) {
			System.out.print(pergunta.getPergunta());
			for(Animal animal : animais) {
				Map<String, Boolean> atributos = animal.getAtributos();
				if(atributos.containsKey(pergunta.getPergunta())) {
					System.out.println(" Sim!");
					if(!this.respostas.contains(animal)) {
						this.respostas.add(animal);
					}
				}else {
					this.respostas.remove(animal);
				}
			}
		}
		System.out.println("---- É um Cachorro? ----");
		setResposta(this.respostas.get(0));
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

	public Animal getResposta() {
		return resposta;
	}

	public void setResposta(Animal resposta) {
		this.resposta = resposta;
	}
	
}
