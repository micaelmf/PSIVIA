package Teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

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
	void esperaAnimalDiferenteDoProcurado() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("diferente");
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
		
		assertEquals("Duiker-zebrado", retorno);
	}
	
	@Test
	void insereNovaPerguntaParaAnimalDiferenteDoProcurado() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
		Random random = new Random();
		
		int numAleatorio = random.nextInt();
		String codigo = Integer.toString(numAleatorio) ;
		
		Animal a = new Animal(codigo);
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
		
		boolean resultado = false;
		Map<String,Boolean> novosAtributos = new LinkedHashMap<>();
		if(retorno != a.getNome()) {
			novosAtributos.put(codigo, true);
			Animal novoAnimal = new Animal(a.getNome(),novosAtributos);
			resultado = daoAnimal.gravarAnimal(novoAnimal);
		}
		
		assertEquals(true, resultado);
	}
}
