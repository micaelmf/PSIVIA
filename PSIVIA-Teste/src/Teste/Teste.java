package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Animal;
import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		
		Animal animal = new Animal("Cachorro");
		resposta.setProcurar(animal.getNome());
		resposta.setResposta();
		String retorno = resposta.getResposta();  
		
		assertEquals(animal.getNome(), retorno);
	}
	
	@Test
	void esperaRespostaGato() {
		Resposta resposta = new Resposta();
		
		Animal animal = new Animal("Gato");
		resposta.setProcurar(animal.getNome());
		resposta.setResposta();
		String retorno = resposta.getResposta();  
		
		assertEquals(animal.getNome(), retorno);
	}
}
