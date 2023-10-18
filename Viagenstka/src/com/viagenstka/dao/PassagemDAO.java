package com.viagenstka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.viagenstka.model.Passagem;
import com.viagenstka.model.Pessoa;
import com.viagenstka.utils.Colors;

public class PassagemDAO {
	
    private static String sql;
    private final Connection connection;

    public PassagemDAO(Connection connection) {
        this.connection = connection;
    }
    
	// CRIAR CLIENTES
    public void criarPassagem(Passagem passagem) {
        sql = "INSERT INTO Passagem (idPessoa, dataViagemPassagem, precoPassagem, destinoPassagem, precoPromocionalPassagem, assentoPassagem, onibusPassagem) " +
              "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passagem.getIdPessoa());
            stmt.setTimestamp(2, passagem.getDataViagemPassagem());
            stmt.setDouble(3, passagem.getPrecoPassagem());
            stmt.setString(4, passagem.getDestinoPassagem());
            stmt.setDouble(5, passagem.getPrecoPromocionalPassagem());
            stmt.setString(6, passagem.getAssentoPassagem());
            stmt.setString(7, passagem.getOnibusPassagem());

            stmt.executeUpdate();

            System.out.println(Colors.BLUE_BOLD.get() + "PASSAGEM CRIADA PARA O DESTINO: " + passagem.getDestinoPassagem() + Colors.RESET.get());
        } catch (SQLException e) {
            System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
        }
    }  
	//ENCERRA CRIAR CLIENTES
    
    // DELETAR PASSAGEM    
    public void deletarPassagem(int idPassagem) {
	    sql = "DELETE FROM passagem WHERE idPassagem = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setInt(1, idPassagem);
	        int contador = stmt.executeUpdate();

	        if (contador > 0) {
	            System.out.println(Colors.GREEN_BOLD.get() + "PASSAGEM COM ID " + idPassagem + " FOI EXCLUÍDO COM SUCESSO!" + Colors.RESET.get());
	        } else {
	            System.out.println(Colors.RED_BOLD.get() + "PASSAGEM COM ID " + idPassagem + " NÃO ENCONTRADO. NENHUM CLIENTE FOI EXCLUÍDO." + Colors.RESET.get());
	        }
	    } catch (SQLException e) {
	        System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
	    }
	}
  // ENCERRA DELETAR PASSAGEM
    
    // MOSTRAR PASSAGENS
    public void mostrarPassagem() {
        sql = "SELECT * FROM Passagem";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            boolean vazio = true;
            while (resultado.next()) {
            	vazio = false;
                Passagem passagem = new Passagem();

                passagem.setIdPassagem(resultado.getInt("idPassagem"));
                passagem.setIdPessoa(resultado.getInt("idPessoa"));
                passagem.setDataViagemPassagem(resultado.getTimestamp("dataViagemPassagem"));
                passagem.setPrecoPassagem(resultado.getDouble("precoPassagem"));
                passagem.setDestinoPassagem(resultado.getString("destinoPassagem"));
                passagem.setPrecoPromocionalPassagem(resultado.getDouble("precoPromocionalPassagem"));
                passagem.setAssentoPassagem(resultado.getString("assentoPassagem"));
                passagem.setOnibusPassagem(resultado.getString("onibusPassagem"));

                System.out.println("ID - PASSAGEM: " + passagem.getIdPassagem());
                System.out.println("ID - CLIENTE: " + passagem.getIdPessoa()); 
                System.out.println("DATA DA PASSAGEM: " + passagem.getDataViagemPassagem());
                System.out.println("PREÇO DA PASSAGEM: " + passagem.getPrecoPassagem());
                System.out.println("DESTINO DO CLIENTE: " + passagem.getDestinoPassagem());
                System.out.println("VALOR PROMOCIONAL: " + passagem.getPrecoPromocionalPassagem());
                System.out.println("ASSENTO: " + passagem.getAssentoPassagem());
                System.out.println("ONIBUS: " + passagem.getOnibusPassagem());
            }

            if (vazio) {
                System.out.println(Colors.BLUE_BOLD.get() + "INFORMAÇÃO: NENHUMA PASSAGEM NO SISTEMA" + Colors.RESET.get());
            }
        } catch (SQLException e) {
            System.out.println(Colors.RED_BOLD.get() + "Erro: " + e.getMessage() + Colors.RESET.get());
        }
    }
    // ENCERA MOSTRAR PASSAGEM
    
    public void atualizarPassagem(Passagem passagem) {
        sql = "UPDATE Passagem SET dataViagemPassagem = ?, precoPassagem = ?, destinoPassagem = ?, precoPromocionalPassagem = ?, assentoPassagem = ?, onibusPassagem = ?  WHERE idPassagem = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, passagem.getDataViagemPassagem());
            stmt.setDouble(2, passagem.getPrecoPassagem());
            stmt.setString(3, passagem.getDestinoPassagem());
            stmt.setDouble(4, passagem.getPrecoPromocionalPassagem());
            stmt.setString(5, passagem.getAssentoPassagem());
            stmt.setString(6, passagem.getOnibusPassagem());
            stmt.setInt(7, passagem.getIdPassagem());
            stmt.executeUpdate();
            System.out.println(Colors.GREEN_BOLD.get() + "PASSAGEM COM ID " + passagem.getIdPassagem() + " ATUALIZADA!" + Colors.RESET.get());
        } catch (SQLException e) {
            System.out.println(Colors.RED_BOLD.get() + "ERRO: " + e.getMessage() + Colors.RESET.get());
        }
    }
}
