package Dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Animal {
	private String nome;
	ArrayList<String> atributos;
	
	public Animal() {
		
	}
	
	public Animal(String nome) {
		this.nome = nome;
	}
	
	public Animal(String nome, ArrayList<String> atributos) {
		this.nome = nome;
		this.atributos = atributos;
	}
	
	public void setAtributo(String atributo) {
		this.atributos.add(atributo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<String> atributos) {
		this.atributos = atributos;
	}
	
}
