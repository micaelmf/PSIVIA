package Teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;
import Dominio.Animal;
import Dominio.Pergunta;
import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Cachorro"); 
		Animal animal = daoAnimal.carregaAnimal(a);
		Map<String,Boolean> atributosDoAnimal = new LinkedHashMap<>();
		atributosDoAnimal = animal.getAtributos();
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		for(Pergunta p : perguntas) {
			if(atributosDoAnimal.containsKey(p.getPergunta())) {
				atributos.put(p.getPergunta(), true);
			}else {
				atributos.put(p.getPergunta(), false);
			}
		}
		
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();   
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGato() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Gato");
		Animal animal = daoAnimal.carregaAnimal(a);
		Map<String,Boolean> atributosDoAnimal = new LinkedHashMap<>();
		atributosDoAnimal = animal.getAtributos();
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		for(Pergunta p : perguntas) {
			if(atributosDoAnimal.containsKey(p.getPergunta())) {
				atributos.put(p.getPergunta(), true);
			}else {
				atributos.put(p.getPergunta(), false);
			}
		}
		
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();   
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGalinha() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Galinha");
		Animal animal = daoAnimal.carregaAnimal(a);
		Map<String,Boolean> atributosDoAnimal = new LinkedHashMap<>();
		atributosDoAnimal = animal.getAtributos();
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		for(Pergunta p : perguntas) {
			if(atributosDoAnimal.containsKey(p.getPergunta())) {
				atributos.put(p.getPergunta(), true);
			}else {
				atributos.put(p.getPergunta(), false);
			}
		}
		
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();   
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void retornaNenhumAnimal() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("G");
		Animal animal = daoAnimal.carregaAnimal(a);
		Map<String,Boolean> atributosDoAnimal = new LinkedHashMap<>();
		atributosDoAnimal = animal.getAtributos();
		
		Map<String,Boolean> atributos = new LinkedHashMap<>();
		for(Pergunta p : perguntas) {
			if(atributosDoAnimal.containsKey(p.getPergunta())) {
				atributos.put(p.getPergunta(), true);
			}else {
				atributos.put(p.getPergunta(), false);
			}
		}
		
		resposta.setProcurar(animal.getNome());
		resposta.setResposta(atributos);
		String retorno = resposta.getResposta();   
		
		if(retorno != animal.getNome()) {
			//persistir nova pergunta e resposta
			
//			Pergunta p6 = new Pergunta("Dá leite?");
//			perguntas.add(p6);
//			atributos.put(p6.getPergunta(), true);
		}
		
		assertEquals(animal.getNome(), retorno);
	}
}
