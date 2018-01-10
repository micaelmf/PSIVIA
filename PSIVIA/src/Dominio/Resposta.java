package Dominio;

import java.util.HashMap;
import java.util.Map;

public class Resposta {
	private String procurar;
	private Animal resposta;
	
	
	public void procurarResposta() {
		Map<String,Boolean> atributos1 = new HashMap<>();
		Pergunta p1 = new Pergunta("Tem rabo?");
		Pergunta p2 = new Pergunta("Tem 4 patas?");
		Pergunta p3 = new Pergunta("Tem pêlos?");
		Pergunta p4 = new Pergunta("Ele late?");
		atributos1.put(p1.getPergunta(), true);
		atributos1.put(p2.getPergunta(), true);
		atributos1.put(p3.getPergunta(), true);
		atributos1.put(p4.getPergunta(), true);
		Animal a1 = new Animal("Cachorro", atributos1);
		
		setResposta(a1);
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
