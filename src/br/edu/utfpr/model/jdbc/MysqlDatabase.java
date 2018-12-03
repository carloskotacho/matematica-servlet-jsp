package br.edu.utfpr.model.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MysqlDatabase {

	private static final String URL = "jdbc:mysql://127.0.0.1/";
	private static final String DATABASE = "matematica";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "12345";
	
	protected Connection conn;
	protected Statement stm;
	
	protected void openDB() {
		try {
			Class.forName(DRIVER_CLASS).newInstance();
			conn = (Connection) DriverManager.getConnection(URL+DATABASE, USER, PASSWORD);
			stm = (Statement) conn.createStatement();
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao abrir o Banco de dados:+\n\t" + e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void closeDB() {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}catch(SQLException e) {
			throw new RuntimeException("Erro ao fechar o Banco de dados:+\n\t" + e.getMessage());
		}
	}
}

