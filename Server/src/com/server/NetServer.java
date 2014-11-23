package com.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetServer extends Listener {

	static sql_interaktion SQLSERVER;
	static Network_Server NetServer;
	static Algorithmen alg = new Algorithmen();
	static Logger SLogger = new Logger("C:\\Logger");
	
	public static void main(String[] args) throws Exception {
		SLogger.Info("Anwendung wird gestartet.");
		SQLSERVER = new sql_interaktion();
		if (SQLSERVER.start() == 1)
			System.exit(0);
		else
			SLogger.Info("SQL Server erfolgreich gestartet.");
			NetServer = new Network_Server();
			SLogger.Info("Netzwerkserver erfolgreich gestartet.");
			Thread.sleep(5000);
			SLogger.Info("Netzwerkserver erfolgreich gestartet.");

	}

	public void connected(Connection c) {
		//Überarbeiten
	}

	public void received(Connection c, Object p) {

		if (p instanceof Registrationspaket) {
			alg.Registration(SQLSERVER, c, p);
		}
		
	}

	public void disconnected(Connection c) {
		System.out.println("A client disconnected!");
	}
}