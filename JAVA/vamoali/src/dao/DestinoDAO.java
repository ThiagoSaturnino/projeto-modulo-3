package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Destino;

public class DestinoDAO {
	public void create(Destino destino) {

		String sql = "insert into destino (nome,data_embarque,estado) values (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getDataEmbarque());
			pstm.setString(3, destino.getEstado());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public List<Destino> read() {
		List<Destino> destinos = new ArrayList<Destino>();
		String sql = "select * from destino";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setId(rset.getInt("id_destino"));
				destino.setNome(rset.getString("nome"));
				destino.setDataEmbarque(rset.getString("data_Embarque"));
				destino.setEstado(rset.getString("estado"));
				
				destinos.add(destino);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return destinos;
	}
	public void update(Destino destino) {
		String sql = "UPDATE Destino SET nome=?,data_embarque=?,estado=? WHERE id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getDataEmbarque());
			pstm.setString(3, destino.getEstado());
			pstm.setInt(4, destino.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void delete(int id) {
		String sql = "DELETE FROM Destino WHERE id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public Destino  readById(int id) {
		Destino destino = new Destino();
		String sql = "select * from Destino WHERE id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			destino.setId(rset.getInt("id_destino"));
			destino.setNome(rset.getString("nome"));
			destino.setDataEmbarque(rset.getString("data_Embarque"));
			destino.setEstado(rset.getString("estado"));
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}
}
