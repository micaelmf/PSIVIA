package Teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.Test;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;
import Dominio.Animal;
import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Cachorro"); 
		Animal animal = daoAnimal.carregaAnimal(a);
		
		Map<String,Boolean> atributos = animal.getAtributos();
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			for(int i=0; i < atributos.size(); i++) {
				if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(true)) {
					atributos2.put(perguntas.get(i), true);
				}else if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(false)){
					atributos2.put(perguntas.get(i), false);
				}
			}
		}
		
		String retorno = resposta.responder(animal.getNome(), atributos2);
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGato() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Gato"); 
		Animal animal = daoAnimal.carregaAnimal(a);
		
		Map<String,Boolean> atributos = animal.getAtributos();
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			for(int i=0; i < atributos.size(); i++) {
				if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(true)) {
					atributos2.put(perguntas.get(i), true);
				}else if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(false)){
					atributos2.put(perguntas.get(i), false);
				}
			}
		}
		
		String retorno = resposta.responder(animal.getNome(), atributos2);
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGalinha() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal("Galinha"); 
		Animal animal = daoAnimal.carregaAnimal(a);
		
		Map<String,Boolean> atributos = animal.getAtributos();
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			for(int i=0; i < atributos.size(); i++) {
				if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(true)) {
					atributos2.put(perguntas.get(i), true);
				}else if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(false)){
					atributos2.put(perguntas.get(i), false);
				}
			}
		}
		
		String retorno = resposta.responder(animal.getNome(), atributos2);
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaAnimalDiferenteDoProcurado() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		Animal a = new Animal(); 
		Animal animal = daoAnimal.carregaAnimal(a);
		
		Map<String,Boolean> atributos = animal.getAtributos();
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			for(int i=0; i < atributos.size(); i++) {
				if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(true)) {
					atributos2.put(perguntas.get(i), true);
				}else if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(false)){
					atributos2.put(perguntas.get(i), false);
				}
			}
		}
		
		String retorno = resposta.responder(animal.getNome(), atributos2);
		
		assertNotEquals("Diferente", retorno);
	}
	
	@Test
	void insereNovaPerguntaParaAnimalDiferenteDoProcurado() {
		Resposta resposta = new Resposta();
		
		AnimalDAO daoAnimal = new AnimalDAO();
		PerguntaDAO daoPergunta = new PerguntaDAO();
		
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		Random random = new Random();
		
		int numAleatorio = random.nextInt();
		String codigo = Integer.toString(numAleatorio) ;
		
		Animal a = new Animal(codigo);
		Animal animal = daoAnimal.carregaAnimal(a);
		
		Map<String,Boolean> atributos = animal.getAtributos();
		Map<String,Boolean> atributos2 = new LinkedHashMap<>();
		
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			for(int i=0; i < atributos.size(); i++) {
				if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(true)) {
					atributos2.put(perguntas.get(i), true);
				}else if(atributo.getKey().equals(perguntas.get(i)) && atributo.getValue().equals(false)){
					atributos2.put(perguntas.get(i), false);
				}
			}
		}
		
		String retorno = resposta.responder(animal.getNome(), atributos);
		
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
