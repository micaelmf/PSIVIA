package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Resposta;

class Teste {

	@Test
	void esperaRespostaCachorro() {
		String procurar = "Cachorro";
		
		Resposta resposta = new Resposta();
		resposta.setProcurar(procurar);
		
		String retorno = resposta.exibirResposta("Cachorro"); 
		assertEquals("Cachorro", retorno);
	}

}
