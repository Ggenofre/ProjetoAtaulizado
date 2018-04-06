package dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import model.Olimpiadas;


		public class OlimpiadasDAO {
			public int criar(Olimpiadas olimpiadas) {
				String sqlInsert = "INSERT INTO olimpiadas(ano, tipo) VALUES (?, ?, ?)";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
					stm.setInt(1, olimpiadas.getid_Ano());
					stm.setString(2, olimpiadas.getTipo());
					stm.execute();
					String sqlQuery = "SELECT LAST_INSERT_ID()";
					try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
							ResultSet rs = stm2.executeQuery();) {
						if (rs.next()) {
							olimpiadas.setid_Ano(rs.getInt(1));
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return olimpiadas.getid_Ano();
			}

			public void atualizar(Olimpiadas olimpiadas) {
				String sqlUpdate = "UPDATE olimpiadas SET ano=?, tipo=? WHERE id_olimpiadas=?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
					stm.setInt(1, olimpiadas.getid_Ano());
					stm.setString(2, olimpiadas.getTipo());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(int id) {
				String sqlDelete = "DELETE FROM olimpiadas WHERE id_olimpiadas = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, id);
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public Olimpiadas carregar(int id_ano) {
				Olimpiadas olimpiadas = new Olimpiadas();; 
				olimpiadas.setid_Ano(id_ano);
				String sqlSelect = "SELECT  tipo FROM olimpiadas WHERE olimpiadas.id_ano = ?";
				// usando o try with resources do Java 7, que fecha o que abriu
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, olimpiadas.getid_Ano());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							olimpiadas.setid_Ano(rs.getInt("ano"));
							olimpiadas.setTipo(rs.getString("tipo"));		
						} else {
							olimpiadas.setid_Ano(-1);
							olimpiadas.setTipo(null);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return olimpiadas;
			}

		}



