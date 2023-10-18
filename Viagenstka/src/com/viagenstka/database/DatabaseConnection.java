package com.viagenstka.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.viagenstka.utils.Colors;

public class DatabaseConnection {
	
	private static final String username = "root";
	   private static final String password = "root";
	   private static final String database_url = "jdbc:mysql://localhost:3306/Viagenstka";
	     
	   public static Connection createConnection() {
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.print(Colors.BLUE_BOLD.get() + "DRIVER ENCONTRADO & " + Colors.RESET.get());
		   } catch(ClassNotFoundException e) {
			   System.out.println("Driver não encontrado!"); 
			   System.out.print ("Mensagem: " + e.getMessage());
		   }
		   
		   try { 
			   Connection connection = DriverManager.getConnection(database_url,username,password);
			   System.out.println (Colors.BLUE_BOLD.get() + "CONECTADO" + Colors.RESET.get());
			   return connection;
			   
		   } catch (SQLException e) {
			   System.out.println ("Erro na conexão do Banco!");
			   System.out.println ("Mensagem: " + e.getMessage());
			   return null;
		   }
	   
}
}
