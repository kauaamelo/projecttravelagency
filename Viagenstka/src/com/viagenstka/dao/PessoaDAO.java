package com.viagenstka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.viagenstka.model.Pessoa;
import com.viagenstka.utils.Colors;

public class PessoaDAO {
	
	private static String sql;
	private final Connection connection;
	
	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}
	
	// CRIAR CLIENTES	
	public void criarPessoa(Pessoa pessoa) {
		sql = "INSERT INTO pessoa (nomeCompletoPessoa, cpfPessoa, endere�oPessoa, telefonePessoa, rgPessoa) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, pessoa.getNomeCompletoPessoa());
			stmt.setString(2, pessoa.getCpfPessoa());
			stmt.setString(3, pessoa.getEndere�oPessoa());
			stmt.setString(4, pessoa.getTelefonePessoa());
			stmt.setString(5, pessoa.getRgPessoa());
			stmt.executeUpdate();
			System.out.println(Colors.BLUE_BOLD.get() + "CLIENTE: " + pessoa.getNomeCompletoPessoa() + " adicionado!" + Colors.RESET.get());			
		}catch(SQLException e){
			System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
		}
	}	
	//ENCERRA CRIAR CLIENTES
	
	// MOSTRAR TODOS CLIENTES
	public void mostrarPessoa() {
	    sql ="SELECT * FROM pessoa";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)){
	        ResultSet resultado = stmt.executeQuery();
	        while (resultado.next()) {
	            Pessoa pessoa = new Pessoa();

	            pessoa.setIdPessoa(resultado.getInt("idPessoa"));
	            pessoa.setNomeCompletoPessoa(resultado.getString("nomeCompletoPessoa"));
	            pessoa.setCpfPessoa(resultado.getString("cpfPessoa"));
	            pessoa.setEndere�oPessoa(resultado.getString("endere�oPessoa"));
	            pessoa.setTelefonePessoa(resultado.getString("telefonePessoa"));
	            pessoa.setRgPessoa(resultado.getString("rgPessoa"));

	            System.out.println("ID - CLIENTE: " + pessoa.getIdPessoa());
	            System.out.println("NOME: " + pessoa.getNomeCompletoPessoa());
	            System.out.println("CPF: " + pessoa.getCpfPessoa());
	            System.out.println("ENDERE�O: " + pessoa.getEndere�oPessoa());
	            System.out.println("TELEFONE: " + pessoa.getTelefonePessoa());
	            System.out.println("RG: " + pessoa.getRgPessoa());
	        }
	    } catch (SQLException e) {
	        System.out.println(Colors.RED_BOLD + "Erro: " + e.getMessage() + Colors.RESET);
	    }
	}
	// ENCERRA TODOS CLIENTES
	
	// ATUALIZAR CLIENTE	
	public void atualizarPessoa(Pessoa pessoa) {
	    sql = "UPDATE pessoa SET nomeCompletoPessoa = ?, cpfPessoa = ?, endere�oPessoa = ?, telefonePessoa = ?, rgPessoa = ? WHERE idPessoa = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, pessoa.getNomeCompletoPessoa());
	        stmt.setString(2, pessoa.getCpfPessoa());
	        stmt.setString(3, pessoa.getEndere�oPessoa());
	        stmt.setString(4, pessoa.getTelefonePessoa());
	        stmt.setString(5, pessoa.getRgPessoa());
	        stmt.setInt(6, pessoa.getIdPessoa());

	        stmt.executeUpdate();

	        System.out.println(Colors.GREEN_BOLD.get() + "CLIENTE COM ID " + pessoa.getIdPessoa() + " ATUALIZADO!" + Colors.RESET.get());
	    } catch (SQLException e) {
	        System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
	    }
	}	
	// ENCERRA ATUALIZAR CLIENTE
	
	// DELETAR CLIENTE	
	public void deletarPessoa(int idPessoa) {
	    sql = "DELETE FROM pessoa WHERE idPessoa = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setInt(1, idPessoa);
	        int contador = stmt.executeUpdate();

	        if (contador > 0) {
	            System.out.println(Colors.GREEN_BOLD.get() + "CLIENTE COM ID " + idPessoa + " FOI EXCLU�DO COM SUCESSO!" + Colors.RESET.get());
	        } else {
	            System.out.println(Colors.RED_BOLD.get() + "CLIENTE COM ID " + idPessoa + " N�O ENCONTRADO. NENHUM CLIENTE FOI EXCLU�DO." + Colors.RESET.get());
	        }
	    } catch (SQLException e) {
	        System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
	    }
	}	
	// ENCERRA DELETAR CLIENTE

}
