package Dominio;

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
		if(!this.atributos.containsKey(chave)) {
			this.atributos.put(chave, valor);
		}
	}
	
	public boolean getAtributo(String chave) {
		for(Map.Entry<String, Boolean> atributo : atributos.entrySet()) {
			if(atributo.getKey().equals(chave)) {
				return atributo.getValue();
			}
		}
		return false;
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
