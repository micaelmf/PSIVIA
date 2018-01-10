package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Animal;
import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		Resposta resposta = new Resposta();
		resposta.setProcurar("Cachorro");
		
		Animal animal = new Animal("Cachorro");
		resposta.procurarResposta();
		Animal retorno = resposta.getResposta(); 
		
		assertEquals("Cachorro", retorno.getNome());
	}

}
