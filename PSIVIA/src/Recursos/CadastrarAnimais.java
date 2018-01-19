package Recursos;

import java.util.LinkedHashMap;
import java.util.Map;

import DAO.AnimalDAO;
import Dominio.Animal;
import Dominio.Resposta;

public class CadastrarAnimais {

	public static void main(String[] args) {
		
		Resposta r = new Resposta();
		System.out.println("\n\n----< É um " + r.responder() + "? >----\n\n");
		System.exit(0);
//		AnimalDAO daoAnimal = new AnimalDAO();
//		Map<String,Boolean> atributos = null;
//		Animal animal = null;
//		
//		atributos = new LinkedHashMap<>();
//		atributos.put("Tem rabo?", true);
//		atributos.put("Tem 4 patas?", true);
//		atributos.put("Tem pêlos?", true);
//		atributos.put("Tem chifre?", true);
//		atributos.put("Ele berra?", true);
//		atributos.put("Dá leite?", true);
//		animal = new Animal("Vaca",atributos);
//		daoAnimal.gravarAnimal(animal);
//		
//		atributos = new LinkedHashMap<>();
//		atributos.put("Tem rabo?", true);
//		atributos.put("Tem 4 patas?", true);
//		atributos.put("Tem pêlos?", true);
//		atributos.put("Ele mia?", true);
//		animal = new Animal("Gato",atributos);
//		daoAnimal.gravarAnimal(animal);
//		
//		atributos = new LinkedHashMap<>();
//		atributos.put("Tem rabo?", true);
//		atributos.put("Tem 4 patas?", true);
//		atributos.put("Tem pêlos?", true);
//		atributos.put("Ele late?", true);
//		animal = new Animal("Cachorro",atributos);
//		daoAnimal.gravarAnimal(animal);
//		
//		atributos = new LinkedHashMap<>();
//		atributos.put("Tem 2 patas?", true);
//		atributos.put("Tem penas?", true);
//		atributos.put("Tem asa?", true);
//		atributos.put("Bota ovo?", true);
//		atributos.put("Cacareja?", true);
//		animal = new Animal("Galinha",atributos);
//		daoAnimal.gravarAnimal(animal);
	}

}
