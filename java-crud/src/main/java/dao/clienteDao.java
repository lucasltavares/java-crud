package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MysqlConnection;
import model.Cliente;

public class clienteDao implements Crud{
	
	private static Connection conn = MysqlConnection.createConnection();
	
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES (null, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getNascimento());
			ps.setString(4, cliente.getSituacao());
			
			ps.executeUpdate();
			
			System.out.println("--Correct insert on database");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect insert on database. " + e.getMessage());
		}
	}
	
	public static void delete(int clienteId) {
		sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, clienteId);
			ps.executeUpdate();
			
			System.out.println("--correct delete on clientes");
			
		} catch (SQLException e) {
			System.out.println("--incorrect delete on cliente. " + e.getMessage());
		}
	}
	
	public static List<Cliente> find(String pesquisa) {
		
		sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' or cpf like '%s%%'", pesquisa, pesquisa);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			
			while (resultset.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(resultset.getInt("id"));
				cliente.setCpf(resultset.getString("cpf"));
				cliente.setNome(resultset.getString("nome"));
				cliente.setNascimento(resultset.getString("nascimento"));
				cliente.setSituacao(resultset.getString("situacao"));
				
				clientes.add(cliente);
			}
			
			System.out.println("--correct find clientes");
			return clientes;
					
		} catch(SQLException e) {
			System.out.println("--incorrect find clientes" + e.getMessage());
			return null;
		}
		
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM clientes WHERE id = %d", clienteId);
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while (resultset.next()) {
				
				
				cliente.setId(resultset.getInt("id"));
				cliente.setCpf(resultset.getString("cpf"));
				cliente.setNome(resultset.getString("nome"));
				cliente.setNascimento(resultset.getString("nascimento"));
				cliente.setSituacao(resultset.getString("situacao"));
				
			}
			
			System.out.println("--correct find by pkclientes");
			return cliente;
					
		} catch(SQLException e) {
			System.out.println("--incorrect find by pk clientes" + e.getMessage());
			return null;
		}
	}
	
	public static void update(Cliente cliente) {
		sql = "UPDATE clientes set nome=?, cpf=?, nascimento=?, situacao=? WHERE id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getNascimento());
			ps.setString(4, cliente.getSituacao());
			ps.setInt(5, cliente.getId());
			
			ps.executeUpdate();
			
			System.out.println("--Correct update on database");
			
		} catch(SQLException e) {
			System.out.println("--Incorrect update on database. " + e.getMessage());
		}
	}
}
