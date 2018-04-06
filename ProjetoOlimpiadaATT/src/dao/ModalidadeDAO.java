package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Modalidade;


public class ModalidadeDAO {
	public Modalidade carregar(int id) {
		Modalidade modalidade = new Modalidade();
		String sqlSelect = "SELECT nome, ouro, prata, bronze FROM modalidade WHERE modalida.id_modalidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, modalidade.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					modalidade.setNome(rs.getString("nome"));
					modalidade.setOuro(rs.getInt("ouro"));
					modalidade.setPrata(rs.getInt("prata"));
					modalidade.setBronze(rs.getInt("bronze"));
				} else {
					modalidade.setId(-1);
					modalidade.setNome(null);
					modalidade.setOuro(-1);
					modalidade.setPrata(-1);
					modalidade.setBronze(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return modalidade;
	}
}
