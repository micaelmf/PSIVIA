package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Animal {
	private String nome;
	Map<String, Boolean> atributos = new LinkedHashMap<>();
	
	public Animal() {
		
	}
	
	public Animal(String nome) {
		this.nome = nome;
	}
	
	public Animal(String nome, Map<String, Boolean> atributos) {
		this.nome = nome;
		setAtributos(atributos);
	}
	
	public void setAtributo(String chave, boolean valor) {
		this.atributos.put(chave, valor);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Boolean> getAtributos() {
		return atributos;
	}

	public void setAtributos(Map<String, Boolean> atributos) {
		this.atributos.putAll(atributos);
	}
	
}
