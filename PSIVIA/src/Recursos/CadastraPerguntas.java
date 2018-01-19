package Recursos;

import java.util.ArrayList;

import DAO.PerguntaDAOX;
import Dominio.PerguntaX;

public class CadastraPerguntas {

	public static void main(String[] args) {
		PerguntaDAOX dao = new PerguntaDAOX();
		PerguntaX p = null;

//		p = new Pergunta("Tem rabo?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem 4 patas?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem pêlos?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Ele late?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Ele mia?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem chifre?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Ele berra?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Dá leite?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Bota ovo?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem asa?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Cacareja?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem 2 patas?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("Tem penas?");
//		dao.gravarPergunta(p);
//		p = new Pergunta("");
//		dao.gravarPergunta(p);
//		p = new Pergunta("");
//		dao.gravarPergunta(p);
//		
//		p = new Pergunta("?");
//		dao.gravarPergunta(p);
		
		ArrayList<PerguntaX> perguntas = dao.carregaPerguntas();
		
		for(PerguntaX pergunta : perguntas) {
			System.out.println(pergunta.getPergunta());
		}

	}

}
