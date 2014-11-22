package com.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.esotericsoftware.kryonet.Connection;
//Commits
public class Algorithmen {

	public void Registration(sql_interaktion SQLServer, Connection c, Object p) {
		System.out.println("Registrationspacket kam erfolgreich an");
		int cUser = 0, cEmail = 0;
		Registrationspaket packet = (Registrationspaket) p;
		Statement stm;
		try {
			stm = SQLServer.conn.createStatement();

			ResultSet rs = stm
					.executeQuery("SELECT benutzername FROM benutzer "
							+ "	WHERE benutzername='" + packet.nickname + "'");

			if (rs.next()) {
				System.out.println("Benutzername ist schon vorhanden.");
				cUser = 1;
			}
			rs = stm.executeQuery("SELECT email FROM benutzer "
					+ "	WHERE email='" + packet.email + "'");

			if (rs.next()) {
				String x = rs.getString("email");

				if (x != "x") {
					System.out.println("Email ist schon vorhanden.");
					cEmail = 1;
				}
			}
			if (cUser == 0 && cEmail == 0) {
				System.out.println("Account wird erstellt.");
				System.out
						.println("INSERT INTO benutzer (benutzername,passwort,email)"
								+ " VALUES('"
								+ packet.nickname
								+ "','"
								+ packet.passwort
								+ "','"
								+ packet.email
								+ "');");
				stm.executeQuery("INSERT INTO benutzer (benutzername,passwort,email)"
						+ " VALUES('"
						+ packet.nickname
						+ "','"
						+ packet.passwort + "','" + packet.email + "');");
				System.out.println("Account wurde erstellt.");
			}

		} catch (SQLException e) {
			System.out.println("Fehler undso : " + e.toString());
		}
	}

}
