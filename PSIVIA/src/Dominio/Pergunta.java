package Dominio;

import java.util.ArrayList;

import DAO.PerguntaDAO;

public class Pergunta {
	private String pergunta;
	private ArrayList<String> perguntas;
	
	public Pergunta(String pergunta) {
		this.pergunta = pergunta;
		//setPerguntas();
	}

	public void setPergunta(String pergunta) {
		PerguntaDAO perguntas = new PerguntaDAO();
		perguntas.gravaPergunta(pergunta);
	}
	public ArrayList<String> getPerguntas() {
		return perguntas;
		
	}
	public void setPerguntas() {
		PerguntaDAO daoPerg = new PerguntaDAO();
		ArrayList<String> perguntas = daoPerg.carregaPerguntas();
		this.perguntas.addAll(perguntas);
	}

	public String getPergunta() {
		return pergunta;
	}
	
	
}
