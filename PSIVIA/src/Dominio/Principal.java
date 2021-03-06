package Dominio;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Principal {

	private static Scanner scString;
	private static Scanner scInt;

	public static void main(String[] args) {
		PerguntaDAO daoPergunta = new PerguntaDAO();
		scString = new Scanner(System.in);
		scInt = new Scanner(System.in);
		String jogador = null;
		
		System.out.print("|+| Digite seu nome: > ");
		jogador = scString.nextLine();
		
		System.out.println("\n"
				+ "|~| Ol� " + jogador + "! Seja bem-vindo(a) ao QUIZ ANIMAL. Para jogar � muito simples, voc� vai pensar\n"
				+ "|~| em um animal e eu vou tentar adivinh�-lo! Veja as INSTRU��ES:\n"
				+ "|~| \n"
				+ "|~| 1- Pense em um animal.\n"
				+ "|~| 2- Responda as perguntas sobre o animal. Suas respostas podem ser 1 para Sim e 2 para N�o.\n"
				+ "|~| 3- Caso eu n�o consiga adivinhar, digite uma pergunta que eu n�o tenha feito, que a resposta dela seja Sim e que diferencia\n"
				+ "|~| \t o animal dos outros.\n");

		Resposta resposta = new Resposta();

		boolean terminou = false;
		while(!terminou) {
			int preparado = 0;
			while(preparado != 1) {
				System.out.print("|>| " + jogador + ", pense em um animal e digite 1 para Continuar.\n> ");
				preparado = scInt.nextInt();
			}
			File diretorio = new File("C:\\PSIVIA18-1"); 
			File arquivo = new File(diretorio, "dados-perguntas.txt"); 
			if(!arquivo.exists()) {
				daoPergunta.gravarPergunta("Ele mia?");
			}
			AnimalDAO daoAnimal = new AnimalDAO();
			arquivo = new File(diretorio, "dados-animais.txt");
			if(!arquivo.exists()) {
				Map<String,Boolean> atributos = new LinkedHashMap<>();
				atributos.put("Ele mia?", true);
				Animal a = new Animal("Gato",atributos);
				daoAnimal.gravarAnimal(a);
			}
			
			String retorno = resposta.responder();
			
			System.out.println("---------------------------------");
			System.out.println("   ~~~~~ � um " + retorno + "? ~~~~~");
			System.out.println("---------------------------------");
			
			System.out.print("1-Sim ou 2-N�o > ");
			int resp = scInt.nextInt();
			
			while(resp != 1 && resp != 2) {
				System.out.print("Por favor "+ jogador +", digite 1 para Sim ou 2 para N�o\n> ");
				resp = scInt.nextInt();
			}
			
			if(resp == 1) {
				System.out.println("|!| Eu acertei "+jogador+"! Viu como eu sou bom nisso? kkkkk");
				terminou = true;
			}else if(resp == 2){
				System.out.println("|(| Voc� ganhou dessa vez "+ jogador +"! rsrsrsrsrs");
				System.out.print("|?| Em que animal voc� estava pensando?\n> ");
				String nomeNovo = scString.nextLine();
				System.out.print("|?| Qual pergunta eu n�o fiz que diferencia seu animal do meu? (Lembre-se que a resposta para sua pergunta dever ser SIM)\n> ");

				String novaChave = scString.nextLine();
				boolean novoValor = true;
				
				Animal animal = new Animal(nomeNovo);
				animal.setAtributo(novaChave, novoValor);
				//animal.setAtributos(resposta.getNovosAtributos());
				
				daoPergunta.gravarPergunta(novaChave);
				
				Map<String, Boolean> novosAtributos = resposta.getNovosAtributos();
				animal.setAtributos(novosAtributos);
				Animal animalAux = daoAnimal.consultarAnimal(animal);
				
				if(animal.getNome().equals(animalAux.getNome())) {
					daoAnimal.atualizarAnimal(animal);
				}else {
					daoAnimal.gravarAnimal(animal);
				}
				
			}
			
			System.out.print("|?| Vamos brincar de novo?\n> ");
			resp = scInt.nextInt();
			while(resp != 1 && resp != 2) {
				System.out.print("| | N�o entendi sua resposta. Digite 1 para Sim e 2 para N�o.\n> ");
			}
			if(resp == 1) {
				terminou = false;
			}else if(resp == 2){
				terminou = true;
			}
			
		}
	}

}
