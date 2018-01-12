package Dominio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import DAO.AnimalDAO;
import DAO.PerguntaDAO;

public class Principal {

	private static Scanner scString;
	private static Scanner scInt;

	public static void main(String[] args) {
		scString = new Scanner(System.in);
		scInt = new Scanner(System.in);
		String jogador = null;
		
		System.out.print("Digite seu nome:\n> ");
		jogador = scString.nextLine();
		
		System.out.println("\n~ Ol� " + jogador + "! Seja bem-vindo(a) ao QUIZ ANIMAL. Para jogar � muito simples, voc� vai pensar\n"
				+ "~ em um animal e eu vou tentar adivinh�-lo! Veja as INSTRU��ES:\n"
				+ "~ 1- Pense em um animal.\n"
				+ "~ 2- Responda as perguntas sobre o animal. Suas respostas podem ser 1 para Sim e 2 para N�o.\n"
				+ "~ 3- Caso eu n�o consiga adivinhar, digite uma pergunta que eu n�o tenha feito, que a resposta dela seja Sim e que diferencia"
				+ "o animal dos outros.\n");

		Resposta resposta = new Resposta();

		boolean terminou = false;
		while(!terminou) {
			int preparado = 0;
			while(preparado != 1) {
				System.out.print(jogador + ", pense em um animal e digite 1 para Continuar\n> ");
				preparado = scInt.nextInt();
			}
			PerguntaDAO daoPergunta = new PerguntaDAO();
			File diretorio = new File("C:\\PSIVIA18-1"); 
			File arquivo = new File(diretorio, "dados-perguntas.txt"); 
			if(!arquivo.exists()) {
				Pergunta p = new Pergunta("Tem 4 patas?");
				daoPergunta.gravarPergunta(p);
			}
			AnimalDAO daoAnimal = new AnimalDAO();
			arquivo = new File(diretorio, "dados-animais.txt");
			if(!arquivo.exists()) {
				ArrayList<String> atributos = new ArrayList<String>();
				atributos.add("Tem 4 patas?");
				Animal a = new Animal("Duiker-zebrado",atributos);
				daoAnimal.gravarAnimal(a);
			}
			ArrayList<Pergunta> perguntas = daoPergunta.carregaPerguntas();
			
			resposta.setResposta();
			String retorno = resposta.getResposta();
			
			System.out.println("~~~~~ � um " + retorno + "? ~~~~~");
			System.out.println("1-Sim ou 2-N�o\n> ");
			int resp = scInt.nextInt();
			
			while(resp != 1 && resp != 2) {
				System.out.println("Por favor "+ jogador +", digite 1 para Sim ou 2 para N�o\n> ");
				resp = scInt.nextInt();
			}
			
			if(resp == 1) {
				System.out.println("Eu aceitei "+jogador+"! Viu como eu sou bom nisso? kkkkk");
				System.out.println("Tente mais uma vez...");
				terminou = true;
			}else if(resp == 2){
				System.out.println("Voc� ganhou dessa vez "+ jogador +"! rsrsrsrsrs");
				System.out.println("Em que animal voc� estava pensando?\n>");
				String nomeNovo = scString.nextLine();
				System.out.println("Qual pergunta eu n�o fiz que diferencia esse animal? (Lembre-se que a resposta para sua pergunta dever ser SIM)\n> ");

				String novaChave = scString.nextLine();
				boolean novoValor = true;
				
				Animal animal = new Animal(nomeNovo);
				Animal aux1 = daoAnimal.consultarAnimal(animal);
				
				ArrayList<String> atributos = new ArrayList<String>();
				atributos = aux1.getAtributos();
				atributos.add(novaChave);
				animal = new Animal(nomeNovo, atributos);
				
				daoAnimal.apagarAnimal(aux1);
				daoAnimal.gravarAnimal(animal);
				
				Pergunta pergunta = new Pergunta(novaChave);
				daoPergunta.gravarPergunta(pergunta);
			}
			
			System.out.println("Vamos brincar de novo?\n> ");
			resp = scInt.nextInt();
			while(resp != 1 && resp != 2) {
				System.out.println("N�o entendi sua resposta. Digite 1 para Sim e 2 para N�o.");
			}
			if(resp == 1) {
				terminou = false;
			}else if(resp == 2){
				terminou = true;
			}
			
		}
	}

}