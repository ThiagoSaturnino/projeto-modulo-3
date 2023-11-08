package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente;

public class ClienteDAO {
	public void create(Cliente cliente) {

		String sql = "insert into Cliente (nome,telefone, email, endereco,cpf) values (?, ?, ?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getCpf());

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
	public List<Cliente> read() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from cliente";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(rset.getInt("id_cliente"));
				cliente.setNome(rset.getString("nome"));
				cliente.setEmail(rset.getString("email"));
				cliente.setTelefone(rset.getString("telefone"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setEndereco(rset.getString("endereco"));

				clientes.add(cliente);
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

		return clientes;
	}
	public void update(Cliente cliente) {
		String sql = "UPDATE Cliente SET nome=?,telefone=?, email=?, endereco=?,cpf=? WHERE id_cliente = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getCpf());

			pstm.setInt(6, cliente.getId());

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
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";

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
	public Cliente  readById(int id) {
		Cliente cliente = new Cliente();
		String sql = "select * from Cliente WHERE id_cliente = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setId(rset.getInt("id_cliente"));
			cliente.setNome(rset.getString("nome"));
			cliente.setEmail(rset.getString("email"));
			cliente.setTelefone(rset.getString("telefone"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setEndereco(rset.getString("endereco"));


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
		return cliente;
	}
}
