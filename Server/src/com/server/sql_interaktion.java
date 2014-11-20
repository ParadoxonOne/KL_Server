package com.server;

import java.sql.*;

public class sql_interaktion {
	String DB_URL="jdbc:postgresql://77.182.111.99:5432/User";
	
	String USER = "postgres";
	String PASS = "postgres";
	Connection conn;

	public sql_interaktion(String DB_URL, String USER, String PASS) {
		this.DB_URL = DB_URL;
		this.USER = USER;
		this.PASS = PASS;
	}

	public sql_interaktion(String DB_URL) {
		this.DB_URL = DB_URL;
	}

	
	public sql_interaktion() {
	}
	
	public int start() {

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return 0;
		} catch (SQLException e) {
			System.out.println("Konnte nicht verbinden. Fehler : "
					+ e.toString());
			return 1;
		}
	}

}