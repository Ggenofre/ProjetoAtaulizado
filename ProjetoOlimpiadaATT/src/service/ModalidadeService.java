package service;

import model.Modalidade;
import dao.ModalidadeDAO;

public class ModalidadeService {
	ModalidadeDAO dao = new ModalidadeDAO();

	public Modalidade carregar(int id) {
		return dao.carregar(id);
	}

}
