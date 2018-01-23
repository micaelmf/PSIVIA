package Dominio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Resposta {
	Animal ultimoRemovido = new Animal();
	Map<String,Boolean> novosAtributos = new LinkedHashMap<>();
	boolean seguir = true;
	private Scanner scan;
	
	public String responder() {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		AnimalDAO daoAnimal = new AnimalDAO();
		ArrayList<String> perguntas = daoPergunta.carregaPerguntas();
		ArrayList<String> perguntasFeitas = new ArrayList<>();
		ArrayList<Animal> animais = daoAnimal.carregarAnimais();
		ArrayList<Animal> animaisAux = new ArrayList<Animal>(animais);
		scan = new Scanner(System.in);

		for(int i = 0; i < animais.size(); i++) {
			Animal animal = animais.get(i);
			if(animaisAux.contains(animal)) {
				for(String pergunta : perguntas) {
					Map<String,Boolean> ss = animal.getAtributos();
					int resposta = 0;
					if(ss.containsKey(pergunta) && !perguntasFeitas.contains(pergunta) && !animais.isEmpty()) {
						perguntasFeitas.add(pergunta);
						System.out.print("|?| " +pergunta + "? > ");
						resposta = scan.nextInt();
						animaisAux = retornarOsVerdadeiros(animais,pergunta,resposta);
						
					}else if(ss.isEmpty() && animais.contains(animal)){
						//System.out.println(animal.getNome() + "" + pergunta + " Decartado (fora)");
						animais.remove(animal);
						ultimoRemovido = animal;
					}
				}
			}
			if(animais.size() == 1) {
				return animais.get(0).getNome();
			}
			if(animais.isEmpty()) {
				return this.ultimoRemovido.getNome();
			}
		}
		return animais.get(0).getNome();
	}

	public ArrayList<Animal> retornarOsVerdadeiros(ArrayList<Animal> animais, String pergunta, int resposta) {
		int j = 0, tamanho = animais.size();
		boolean add = true;
		
		while(j < animais.size()) {

			Animal proxAnimal = animais.get(j);
			Boolean atributo = proxAnimal.getAtributos().get(pergunta);
			//System.out.print(proxAnimal.getNome() + " " + pergunta);
			/*
			 * se a resposta é 1 - remover animais que contenham a chave e que o valor seja falso
			 * se a resposta é 2 - remover animais que contenham a chave e que o valor seja true
			 */
			if(atributo != null) {
				if(resposta == 1 && atributo == false || resposta == 2 && atributo == true || animais.isEmpty()) {
					//System.out.println(" Decartado 1");
					animais.remove(proxAnimal);
					ultimoRemovido = proxAnimal;
					tamanho--;
					add = false;
					AnimalDAO daoAnimal = new AnimalDAO();
					proxAnimal.setAtributo(pergunta, false);
					daoAnimal.atualizarAnimal(proxAnimal);
				}else if(resposta == 1 && atributo == true || resposta == 2 && atributo == false) {
					//System.out.println(" Mantido 1");
					add = true;
				}else {
					System.out.println("<?><?><?><?> WHAT -1- <?><?><?><?>");
				}
				
				if(!this.novosAtributos.containsKey(pergunta) && resposta == 1) {
					this.novosAtributos.put(pergunta, true);
				}else if (!this.novosAtributos.containsKey(pergunta) && resposta == 2) {
					this.novosAtributos.put(pergunta, false);
				}
			}
			else {
				//System.out.println(" Decartado 2");
				animais.remove(proxAnimal);
				ultimoRemovido = proxAnimal;
				tamanho--;
				add = false;
				AnimalDAO daoAnimal = new AnimalDAO();
				proxAnimal.setAtributo(pergunta, false);
				daoAnimal.atualizarAnimal(proxAnimal);
				if(resposta == 2) {
					proxAnimal.setAtributo(pergunta, false);
					daoAnimal.atualizarAnimal(proxAnimal);
				}
			}
			
			if(add) {
				j++;
			}
		}
		if(tamanho == animais.size()) {
			this.seguir = true;
		}else {
			this.seguir = false;
		}
		return animais;
	}

	public void imprimirClassificados(String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println(matriz[i][j]);
			}
		}
	}

	public Map<String, Boolean> getNovosAtributos() {
		return novosAtributos;
	}

	public void setNovosAtributos(Map<String, Boolean> novosAtributos) {
		this.novosAtributos = novosAtributos;
	}
	
}
