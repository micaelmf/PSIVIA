package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Dominio.Calculadora;

class Teste {

	@Test
	void test() {
		Calculadora c = new Calculadora();
		int retorno = c.mostrar();
		assertEquals(0, retorno);
	}

}
