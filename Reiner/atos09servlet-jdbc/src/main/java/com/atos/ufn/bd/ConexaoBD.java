package com.atos.ufn.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

	public Connection connection;
	public Statement statement;
	public ResultSet rs;
	
	public ConexaoBD() {
	}

	public void conectar() {
		try {
			String address = "localhost";
			String port = "3306";
			String dataBaseName = "atos02";
			String user = "root";
			String password = "12345";

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + dataBaseName
					+ "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC");
			statement = connection.createStatement();

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}

	}

	// Para inserções, alterações e exclusões
	public int executeUpdate(String query) {
		int status = 0;
		try {
			statement = connection.createStatement();
			status = statement.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return status;
	}

	// Para consultas
	public ResultSet executeQuery(String query) {
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return rs;
	}

}