package Teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Dominio.Animal;
import Dominio.Pergunta;
import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
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
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		atributos.put(p1.getPergunta(), true);
		atributos.put(p2.getPergunta(), true);
		atributos.put(p3.getPergunta(), true);
		atributos.put(p4.getPergunta(), true);
		atributos.put(p5.getPergunta(), false);
		
		Animal animal = new Animal("Cachorro");
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();   
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGato() {
		Resposta resposta = new Resposta();
		ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
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
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		atributos.put(p1.getPergunta(), true);
		atributos.put(p2.getPergunta(), true);
		atributos.put(p3.getPergunta(), true);
		atributos.put(p4.getPergunta(), false);
		atributos.put(p5.getPergunta(), true);
		
		Animal animal = new Animal("Gato");
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();  
		
		assertEquals(animal.getNome(), retorno);
	}
}
