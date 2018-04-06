package service;

import model.Olimpiadas;
import dao.OlimpiadasDAO;

	public class OlimpiadasService {
		OlimpiadasDAO dao = new OlimpiadasDAO();
		
		public int criar(Olimpiadas olimpiadas) {
			return dao.criar(olimpiadas);
		}
		
		public void atualizar(Olimpiadas olimpiadas){
			dao.atualizar(olimpiadas);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Olimpiadas carregar(int id){
			return dao.carregar(id);
		}

	}


