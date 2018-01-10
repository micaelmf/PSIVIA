package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		String retorno = resposta.resposta("Cachorro"); 
		assertEquals("Cachorro", retorno);
	}

}
