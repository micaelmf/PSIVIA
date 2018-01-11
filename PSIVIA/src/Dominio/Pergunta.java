package Dominio;

import java.util.ArrayList;

import DAO.PerguntaDAO;

public class Pergunta {
	private String pergunta;

	public Pergunta(String pergunta) {
		setPergunta(pergunta);
	}
	
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
}
