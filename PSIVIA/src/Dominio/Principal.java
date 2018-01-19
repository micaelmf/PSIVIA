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
		
		System.out.print("Digite seu nome:\n> ");
		jogador = scString.nextLine();
		
		System.out.println("\n~ Olá " + jogador + "! Seja bem-vindo(a) ao QUIZ ANIMAL. Para jogar é muito simples, você vai pensar\n"
				+ "~ em um animal e eu vou tentar adivinhá-lo! Veja as INSTRUÇÕES:\n"
				+ "~ 1- Pense em um animal.\n"
				+ "~ 2- Responda as perguntas sobre o animal. Suas respostas podem ser 1 para Sim e 2 para Não.\n"
				+ "~ 3- Caso eu não consiga adivinhar, digite uma pergunta que eu não tenha feito, que a resposta dela seja Sim e que diferencia\n"
				+ "o animal dos outros.\n");

		Resposta resposta = new Resposta();

		boolean terminou = false;
		while(!terminou) {
			int preparado = 0;
			while(preparado != 1) {
				System.out.print(jogador + ", pense em um animal e digite 1 para Continuar\n> ");
				preparado = scInt.nextInt();
			}
			File diretorio = new File("C:\\PSIVIA18-1"); 
			File arquivo = new File(diretorio, "dados-perguntas.txt"); 
			if(!arquivo.exists()) {
				daoPergunta.gravarPergunta("Tem 4 patas?");
			}
			AnimalDAO daoAnimal = new AnimalDAO();
			arquivo = new File(diretorio, "dados-animais.txt");
			if(!arquivo.exists()) {
				Map<String,Boolean> atributos = new LinkedHashMap<>();
				atributos.put("Tem 4 patas?", true);
				Animal a = new Animal("Gato",atributos);
				daoAnimal.gravarAnimal(a);
			}
			
			String retorno = resposta.responder();
			
			System.out.println("~~~~~ É um " + retorno + "? ~~~~~");
			System.out.println("1-Sim ou 2-Não\n> ");
			int resp = scInt.nextInt();
			
			while(resp != 1 && resp != 2) {
				System.out.println("Por favor "+ jogador +", digite 1 para Sim ou 2 para Não\n> ");
				resp = scInt.nextInt();
			}
			
			if(resp == 1) {
				System.out.println("Eu acertei "+jogador+"! Viu como eu sou bom nisso? kkkkk");
				System.out.println("Tente mais uma vez...");
				terminou = true;
			}else if(resp == 2){
				System.out.println("Você ganhou dessa vez "+ jogador +"! rsrsrsrsrs");
				System.out.println("Em que animal você estava pensando?\n>");
				String nomeNovo = scString.nextLine();
				System.out.println("Qual pergunta eu não fiz que diferencia seu animal do meu? (Lembre-se que a resposta para sua pergunta dever ser SIM)\n> ");

				String novaChave = scString.nextLine();
				boolean novoValor = true;
				
				Animal animal = new Animal(nomeNovo);
				animal.setAtributo(novaChave, novoValor);
				//animal.setAtributos(resposta.getNovosAtributos());

				daoAnimal.atualizarAnimal(animal);
				daoPergunta.gravarPergunta(novaChave);
			}
			
			System.out.println("Vamos brincar de novo?\n> ");
			resp = scInt.nextInt();
			while(resp != 1 && resp != 2) {
				System.out.println("Não entendi sua resposta. Digite 1 para Sim e 2 para Não.");
			}
			if(resp == 1) {
				terminou = false;
			}else if(resp == 2){
				terminou = true;
			}
			
		}
	}

}
