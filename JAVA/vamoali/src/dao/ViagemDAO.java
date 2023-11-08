package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente;
import modelo.Destino;
import modelo.Viagem;

public class ViagemDAO {
	public void create(Viagem viagem) {

		String sql = "insert into Viagem (id_cliente,id_destino,data_ida,data_volta,num_passageiros,valor) values (?, ?, ?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, viagem.getCliente().getId());
			pstm.setInt(2, viagem.getDestino().getId());
			pstm.setString(3, viagem.getDataIda());
			pstm.setString(4, viagem.getDataVolta());
			pstm.setInt(5, viagem.getNumPassageiros());
			pstm.setFloat(6, viagem.getValor());

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

	public List<Viagem> read() {
		List<Viagem>viagens = new ArrayList<Viagem>();
		String sql = "select * from viagem";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();
                int id_cliente =rset.getInt("id_cliente");
                ClienteDAO cdao = new ClienteDAO();
                Cliente cliente=cdao.readById(id_cliente);
                int id_destino =rset.getInt("id_destino");
               DestinoDAO ddao = new DestinoDAO();
                Destino destino=ddao.readById(id_destino);
                viagem.setCliente(cliente);
				viagem.setDestino(destino);
				viagem.setDataIda(rset.getString("data_ida"));
				viagem.setDataVolta(rset.getString("data_volta"));
				viagem.setNumPassageiros(rset.getInt("num_passageiros"));
				viagem.setValor(rset.getFloat("valor"));
				viagem.setId(rset.getInt("id_viagem"));
				viagens.add(viagem);
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

		return viagens;
	}
	public void update(Viagem viagem) {
		String sql = "UPDATE viagem SET id_cliente=?,id_destino=?,data_ida=?,data_volta=?,num_passageiros=?,valor=? WHERE id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, viagem.getCliente().getId());
			pstm.setInt(2, viagem.getDestino().getId());
			pstm.setString(3, viagem.getDataIda());
			pstm.setString(4, viagem.getDataVolta());
			pstm.setInt(5, viagem.getNumPassageiros());
			pstm.setFloat(6, viagem.getValor());
			pstm.setInt(7, viagem.getId());

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
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";

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
	public Viagem  readById(int id) {
		Viagem viagem = new Viagem();
		String sql = "select * from Viagem WHERE id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			  int id_cliente =rset.getInt("id_cliente");
              ClienteDAO cdao = new ClienteDAO();
              Cliente cliente=cdao.readById(id_cliente);
              int id_destino =rset.getInt("id_destino");
             DestinoDAO ddao = new DestinoDAO();
              Destino destino=ddao.readById(id_destino);
              viagem.setCliente(cliente);
				viagem.setDestino(destino);
				viagem.setDataIda(rset.getString("data_ida"));
				viagem.setDataVolta(rset.getString("data_volta"));
				viagem.setNumPassageiros(rset.getInt("num_passageiros"));
				viagem.setValor(rset.getFloat("valor"));
				viagem.setId(rset.getInt("id_viagem"));	

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
		return viagem;
	}
}
